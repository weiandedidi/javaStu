import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author maqidi
 * @date 2023/3/17 3:04 PM
 */
public class StreamTest {

    @Test
    public void testPeek() {
        Stream.of("one", "two", "three", "four")
                .peek(e -> {
                    System.out.println("Filtered value: " + e);
                    e = e + "_1";
                })
                .filter(e -> e.length() > 3)
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
