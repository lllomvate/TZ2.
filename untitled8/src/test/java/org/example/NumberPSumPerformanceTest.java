package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberPSumPerformanceTest {

    private static final String[] FILES = {
            "src/test/resources/numbers_100.txt",
            "src/test/resources/numbers_1000.txt",
            "src/test/resources/numbers_10000.txt",
            "src/test/resources/numbers_100000.txt",
            "src/test/resources/numbers_1000000.txt"
    };

    @Test
    public void testSumPerformance() throws IOException {
        for (String file : FILES) {
            measurePerformance(file);
        }
    }

    private void measurePerformance(String filePath) throws IOException {
        List<Integer> numbers = Files.lines(Paths.get(filePath))
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long startTime = System.nanoTime();
        int sum = NumberP._sum(numbers);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.printf("File %s: Sum = %d, Time = %d nanoseconds%n", filePath, sum, duration);
    }
}
