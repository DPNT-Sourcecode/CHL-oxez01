package befaster.solutions.CHL;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scratch {

    @Test
    public void testParsing() {
        char[] chars = "BB".toCharArray();

        Map<String, Long> collect = Stream.of(chars).map(c -> String.valueOf(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

    }
}

