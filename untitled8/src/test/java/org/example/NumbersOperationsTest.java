package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersOperationsTest {

    @BeforeAll
    public static void setup() throws IOException {
        GenerateTestFileMini.main(null);
    }

    private static final String TEST_FILE_1 = "src/test/resources/test1.txt";
    private static final String ANSWER_FILE_1 = "src/test/resources/test1_ans.txt";
    private static final String TEST_FILE_2 = "src/test/resources/test2.txt";
    private static final String ANSWER_FILE_2 = "src/test/resources/test2_ans.txt";
    // Добавьте больше тестовых файлов, если необходимо

    @Test
    public void testFindMin() throws IOException {
        validateResults(TEST_FILE_1, ANSWER_FILE_1, "min");
        validateResults(TEST_FILE_2, ANSWER_FILE_2, "min");
    }

    @Test
    public void testFindMax() throws IOException {
        validateResults(TEST_FILE_1, ANSWER_FILE_1, "max");
        validateResults(TEST_FILE_2, ANSWER_FILE_2, "max");
    }

    @Test
    public void testGetSum() throws IOException {
        validateResults(TEST_FILE_1, ANSWER_FILE_1, "sum");
        validateResults(TEST_FILE_2, ANSWER_FILE_2, "sum");
    }

    @Test
    public void testGetMult() throws IOException {
        validateResults(TEST_FILE_1, ANSWER_FILE_1, "mult");
        validateResults(TEST_FILE_2, ANSWER_FILE_2, "mult");
    }

    private void validateResults(String testFilePath, String answerFilePath, String operation) throws IOException {
        List<Integer> numbers = NumbersOperations.readNumbersFromFile(testFilePath);
        Map<String, Long> answers = readAnswersFromFile(answerFilePath);

        switch (operation) {
            case "min":
                int expectedMin = answers.get("min").intValue();
                assertEquals(expectedMin, NumbersOperations.findMin(numbers));
                break;
            case "max":
                int expectedMax = answers.get("max").intValue();
                assertEquals(expectedMax, NumbersOperations.findMax(numbers));
                break;
            case "sum":
                int expectedSum = answers.get("sum").intValue();
                assertEquals(expectedSum, NumbersOperations.getSum(numbers));
                break;
            case "mult":
                long expectedMult = answers.get("mult");
                assertEquals(expectedMult, NumbersOperations.getMult(numbers));
                break;
        }
    }

    private Map<String, Long> readAnswersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.split(" "))
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(e -> e[0], e -> Long.parseLong(e[1])));
    }
}