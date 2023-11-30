package foxminded.dzaimenko.intdivision;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerDivisionParameterizedTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String[] arrayExpectedOutputData;

    static {
        arrayExpectedOutputData = new String[4];
        arrayExpectedOutputData[0] = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_75545|4" + System.lineSeparator() +
                " 4    |-----" + System.lineSeparator() +
                " -    |18886" + System.lineSeparator() +
                "_7" + System.lineSeparator() +
                " 4" + System.lineSeparator() +
                " -" + System.lineSeparator() +
                " _35" + System.lineSeparator() +
                "  32" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "  _35" + System.lineSeparator() +
                "   32" + System.lineSeparator() +
                "   --" + System.lineSeparator() +
                "   _34" + System.lineSeparator() +
                "    32" + System.lineSeparator() +
                "    --" + System.lineSeparator() +
                "    _25" + System.lineSeparator() +
                "     24" + System.lineSeparator() +
                "     --" + System.lineSeparator() +
                "      1" + System.lineSeparator();

        arrayExpectedOutputData[1] = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|17" + System.lineSeparator() +
                " 17|-" + System.lineSeparator() +
                " --|1" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  17" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   0" + System.lineSeparator();

        arrayExpectedOutputData[2] = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|17" + System.lineSeparator() +
                " 17|-" + System.lineSeparator() +
                " --|1" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  17" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   0" + System.lineSeparator();

        arrayExpectedOutputData[3] = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|4" + System.lineSeparator() +
                " 4 |-" + System.lineSeparator() +
                " - |4" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  16" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   1" + System.lineSeparator();
    }


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testPerformDivision(int dividend, int divisor, String expectedOutput, Class<? extends Exception> expectedException) {
        IntegerDivision integerDivision = new IntegerDivision();

        if (expectedException != null) {
            assertThrows(expectedException, () -> integerDivision.performDivision(dividend, divisor));
        } else {
            integerDivision.performDivision(dividend, divisor);
            assertEquals(expectedOutput, outputStream.toString());
        }
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(75545, 4, arrayExpectedOutputData[0], null),
                Arguments.of(17, 17, arrayExpectedOutputData[1], null),
                Arguments.of(-17, -17, arrayExpectedOutputData[2], null),
                Arguments.of(17, -4, arrayExpectedOutputData[3], null),
                Arguments.of(17, 0, null, IllegalArgumentException.class),
                Arguments.of(0, 0, null, IllegalArgumentException.class),
                Arguments.of(17, 18, null, IllegalArgumentException.class)

        );
    }


}
