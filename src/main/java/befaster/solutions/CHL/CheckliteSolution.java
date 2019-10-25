package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckliteSolution {


    private final ShopRepo repo;
    private final Pricing pricing;

    public CheckliteSolution(ShopRepo repo, Pricing pricing) {
        this.repo = repo;
        this.pricing = pricing;
    }

    public Integer checklite(String skus) {
        boolean validInput = skus.chars().allMatch(c -> validSku(c));
        if (!validInput) {
            return -1;
        }

        Set<BasketItem> basket = createBasket(skus);

        int total = 0;
        for (BasketItem bi : basket) {
            total += pricing.evaluate(bi);
        }
        return total;
    }


    private static boolean validSku(int c) {
        Set<Character> validSkus = new HashSet();
        validSkus.add('A');
        validSkus.add('B');
        validSkus.add('C');
        validSkus.add('D');
        validSkus.add('E');
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

        Set<BasketItem> basket = map.entrySet().stream()
                .map(e -> new BasketItem(repo.getItem(e.getKey()), e.getValue().intValue()))
                .collect(Collectors.toSet());
        return basket;
    }


}
