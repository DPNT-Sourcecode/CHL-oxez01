package befaster.solutions.CHL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckliteSolution {

    private final Set<Character> validSkus;
    private final ShopRepo repo;
    private final Pricing pricing;
    private final List<Promotion> promotions;
    private final List<BogofPromotion> freebies;

    public CheckliteSolution(ShopRepo repo, Pricing pricing, List<Promotion> promotions, List<BogofPromotion> freebies) {
        validSkus = new HashSet();
        for (char all = 'A'; c <= 'Z' ; all++) {
            validSkus.add(all);
        }
        this.repo = repo;
        this.pricing = pricing;
        this.promotions = promotions;
        this.freebies = freebies;
    }

    public Integer checklite(String skus) {
        boolean validInput = skus.chars().allMatch(c -> validSku(c));
        if (!validInput) {
            return -1;
        }
        Set<BasketItem> basket = createBasket(skus);

        // first apply freebies
        for (BogofPromotion bogof: freebies) {
            basket = bogof.apply(basket);
        }
        final Set<BasketItem> newBasket = new HashSet<>(basket);

        // calculate without discount
        int total = newBasket.stream().map(pricing::evaluate).mapToInt(Integer::intValue).sum();

        int totalDiscount = promotions.stream().map(i -> i.discount(newBasket)).mapToInt(Integer::intValue).sum();

        return total - totalDiscount;
    }


    private boolean validSku(int c) {
        return validSkus.contains(Character.valueOf((char) c));
    }

    Set<BasketItem> createBasket(String skus) {
        Map<String, Long> map = skus.chars().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


//        if (map.containsKey("E") && map.get("E").intValue() >= 2) {
//            if (map.containsKey("B")) {
//                int freeBs = map.get("E").intValue() / 2;
//                if (map.get("B").intValue() >= freeBs) {
//                    map.put("B", map.get("B") - freeBs);
//                }
//            }
//        }
//        if (map.containsKey("F") && map.get("F").intValue() >= 3) {
//            int freeEs = map.get("F").intValue() / 3;
//            map.put("F", map.get("F") - freeEs);
//        }

        Set<BasketItem> basket = map.entrySet().stream()
                .map(e -> new BasketItem(repo.getItem(e.getKey()), e.getValue().intValue()))
                .collect(Collectors.toSet());
        return basket;
    }


}


