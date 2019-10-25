package befaster.solutions.CHL;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scratch {

    @Test
    public void testParsing() {
        Map<String, Long> collect = "A".chars().mapToObj(c -> String.valueOf(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

    }
}
