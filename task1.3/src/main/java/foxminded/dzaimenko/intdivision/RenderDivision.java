package foxminded.dzaimenko.intdivision;

public class RenderDivision {

    private int dividend;
    private int divisor;
    private int divisionResult;
    private String stringDividend;
    private String stringDivisor;
    private char[] arrayDividend;
    private int numberOfDigitsInResult;
    int count;

    public RenderDivision(int dividend, int divisor, int divisionResult) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.divisionResult = divisionResult;
        this.stringDividend = Integer.toString(dividend);
        this.stringDivisor = Integer.toString(divisor);
        this.arrayDividend = stringDividend.toCharArray();
        this.numberOfDigitsInResult = String.valueOf(divisionResult).length();
        this.count = stringDividend.length() - stringDivisor.length();

    }

    private void renderDivisionHeader() {
        StringBuilder headerBuilder = new StringBuilder();
        String lineSeparator = System.lineSeparator();

        headerBuilder.append("Column division:").append(lineSeparator);
        headerBuilder.append(lineSeparator);

        headerBuilder.append("_").append(dividend).append("|").append(divisor).append(lineSeparator);

        headerBuilder.append(" ").append(divisor)
                .append(repeatChar(' ', stringDividend.length() - stringDivisor.length()))
                .append("|")
                .append(repeatChar('-', numberOfDigitsInResult))
                .append(lineSeparator);

        headerBuilder.append(" ")
                .append(repeatChar('-', stringDivisor.length()))
                .append(repeatChar(' ', stringDividend.length() - stringDivisor.length()))
                .append("|")
                .append(divisionResult)
                .append(lineSeparator);

        System.out.print(headerBuilder);
    }

    private String repeatChar(char character, int count) {
        return new String(new char[count]).replace('\0', character);
    }

    private void renderDivisionBody() {
        int remainder = 0;
        int position = 0;

        for (char digit : arrayDividend) {
            int current = remainder * 10 + Character.getNumericValue(digit);
            int resultDigit = current / divisor;
            remainder = current % divisor;

            String resultSpace = " ".repeat(position);
            String minusLine = "-".repeat(Integer.toString(resultDigit * divisor).length());

            if (position != 0 || resultDigit != 0) {
                System.out.println(resultSpace + "_" + current);
                System.out.println(resultSpace + " " + (resultDigit * divisor));
                System.out.println(resultSpace + " " + minusLine);
            }

            position++;
        }

        System.out.println("  " + " ".repeat(position - 1) + remainder);
    }

    public void renderDivisionResult() {
        renderDivisionHeader();
        renderDivisionBody();
    }
}
