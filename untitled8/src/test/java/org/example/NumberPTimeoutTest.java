package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class NumberPTimeoutTest {

    @Test
    public void testSumWithTimeout() throws IOException {
        List<Integer> numbers = readNumbersFromFile("src/test/resources/numbers_large.txt");

        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            int sum = NumberP._sum(numbers);
            System.out.println("Sum: " + sum);
        });
    }

    private List<Integer> readNumbersFromFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
