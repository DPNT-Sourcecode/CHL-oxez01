package befaster.solutions.CHL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckliteSolution {


    private final ShopRepo repo;
    private final Pricing pricing;
    private final List<Promotion> promotions;

    public CheckliteSolution(ShopRepo repo, Pricing pricing, List<Promotion> promotions) {
        this.repo = repo;
        this.pricing = pricing;
        this.promotions = promotions;
    }

    public Integer checklite(String skus) {
        boolean validInput = skus.chars().allMatch(c -> validSku(c));
        if (!validInput) {
            return -1;
        }
        Set<BasketItem> basket = createBasket(skus);

        // calculate without discount
        int total = basket.stream().map(pricing::evaluate).mapToInt(Integer::intValue).sum();

        int totalDiscount = promotions.stream().map(i -> i.discount(basket)).mapToInt(Integer::intValue).sum();

        return total - totalDiscount;
    }


    private static boolean validSku(int c) {
        Set<Character> validSkus = new HashSet();
        validSkus.add('A');
        validSkus.add('B');
        validSkus.add('C');
        validSkus.add('D');
        validSkus.add('E');
        validSkus.add('F');
        return validSkus.contains(Character.valueOf((char) c));
    }

    Set<BasketItem> createBasket(String skus) {
        Map<String, Long> map = skus.chars().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        if (map.containsKey("E") && map.get("E").intValue() >= 2) {
            if (map.containsKey("B")) {
                int freeBs = map.get("E").intValue() / 2;
                if (map.get("B").intValue() >= freeBs) {
                    map.put("B", map.get("B") - freeBs);
                }
            }
        }
        if (map.containsKey("F") && map.get("F").intValue() >= 3) {
            int freeEs = map.get("F").intValue() / 3;
            map.put("F", map.get("F") - freeEs);
        }

        Set<BasketItem> basket = map.entrySet().stream()
                .map(e -> new BasketItem(repo.getItem(e.getKey()), e.getValue().intValue()))
                .collect(Collectors.toSet());
        return basket;
    }


}
