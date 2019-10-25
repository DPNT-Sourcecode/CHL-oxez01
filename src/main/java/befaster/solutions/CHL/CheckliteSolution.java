package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashSet;
import java.util.Set;

public class CheckliteSolution {
    public Integer checklite(String skus) {
        boolean validInput = skus.chars().allMatch(c -> validSku(c));
        if (!validInput) {
            return -1;
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
