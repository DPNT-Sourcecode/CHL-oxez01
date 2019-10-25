package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashSet;
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
        Set<BasketItem> basket = skus.chars().mapToObj(c -> String.valueOf(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(e -> new BasketItem(repo.getItem(e.getKey()), e.getValue().intValue()))
                .collect(Collectors.toSet());

        int total = 0;
        for (BasketItem bi : basket) {
            total += pricing.evaluate(bi);
        }


        throw new SolutionNotImplementedException();
    }

    private static boolean validSku(int c) {
        Set<Character> validSkus = new HashSet();
        validSkus.add('A');
        validSkus.add('B');
        validSkus.add('C');
        validSkus.add('D');
        return validSkus.contains(Character.valueOf((char) c));
    }

}


