package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckliteSolution {



    public Integer checklite(String skus) {
        boolean validInput = skus.chars().allMatch(c -> validSku(c));
        if (!validInput) {
            return -1;
        }
//        skus.chars().mapToObj(c -> String.valueOf(c))
//                .collect(Collectors.toMap(Function.identity(), Collectors.counting()));

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
