package org.example;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

public class NumberPPerformanceTest {

    private static final String SMALL_FILE = "src/test/resources/numbers_small.txt";
    private static final String MEDIUM_FILE = "src/test/resources/numbers_medium.txt";
    private static final String LARGE_FILE = "src/test/resources/numbers_large.txt";

    @Test
    public void testPerformanceMin() throws IOException {
        measurePerformance(SMALL_FILE, "min");
        measurePerformance(MEDIUM_FILE, "min");
        measurePerformance(LARGE_FILE, "min");
    }

    @Test
    public void testPerformanceMax() throws IOException {
        measurePerformance(SMALL_FILE, "max");
        measurePerformance(MEDIUM_FILE, "max");
        measurePerformance(LARGE_FILE, "max");
    }

    @Test
    public void testPerformanceSum() throws IOException {
        measurePerformance(SMALL_FILE, "sum");
        measurePerformance(MEDIUM_FILE, "sum");
        measurePerformance(LARGE_FILE, "sum");
    }

    @Test
    public void testPerformanceMult() throws IOException {
        measurePerformance(SMALL_FILE, "mult");
        measurePerformance(MEDIUM_FILE, "mult");
        measurePerformance(LARGE_FILE, "mult");
    }

    private void measurePerformance(String filePath, String operation) throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(filePath);

        long startTime = System.nanoTime();
        switch (operation) {
            case "min":
                NumberP._min(numbers);
                break;
            case "max":
                NumberP._max(numbers);
                break;
            case "sum":
                NumberP._sum(numbers);
                break;
            case "mult":
                NumberP._mult(numbers);
                break;
        }
        long endTime = System.nanoTime();

        System.out.printf("Operation %s on file %s took %d nanoseconds.%n", operation, filePath, (endTime - startTime));
    }
}
