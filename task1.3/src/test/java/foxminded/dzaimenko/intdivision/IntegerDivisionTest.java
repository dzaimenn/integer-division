package foxminded.dzaimenko.intdivision;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerDivisionTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPerformDivisionWithCorrectDividendAndDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.performDivision(75545, 4);

        String expectedOutput = "Column division:" + System.lineSeparator() + System.lineSeparator() +
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
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void testPerformDivisionWithZeroDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();

        assertThrows(IllegalArgumentException.class, () -> integerDivision.performDivision(17, 0));
    }

    @Test
    void testPerformDivisionWithZeroDividendAndDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();

        assertThrows(IllegalArgumentException.class, () -> integerDivision.performDivision(0, 0));
    }

    @Test
    void testPerformDivisionWhenDividendIsLessThanDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();
        assertThrows(IllegalArgumentException.class, () -> integerDivision.performDivision(17,18));
    }

    @Test
    void testPerformDivisionWhenDividendEqualsDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.performDivision(17, 17);

        String expectedOutput = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|17" + System.lineSeparator() +
                " 17|-" + System.lineSeparator() +
                " --|1" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  17" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   0" + System.lineSeparator();
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformDivisionWithNegativeDividendAndDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.performDivision(-17, -17);

        String expectedOutput = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|17" + System.lineSeparator() +
                " 17|-" + System.lineSeparator() +
                " --|1" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  17" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   0" + System.lineSeparator();
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformDivisionWithNegativeDivisor() {
        IntegerDivision integerDivision = new IntegerDivision();
        integerDivision.performDivision(17, -4);

        String expectedOutput = "Column division:" + System.lineSeparator() + System.lineSeparator() +
                "_17|4" + System.lineSeparator() +
                " 4 |-" + System.lineSeparator() +
                " - |4" + System.lineSeparator() +
                " _17" + System.lineSeparator() +
                "  16" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "   1" + System.lineSeparator();
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }


}
