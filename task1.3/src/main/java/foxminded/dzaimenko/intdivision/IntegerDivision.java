package foxminded.dzaimenko.intdivision;

public class IntegerDivision {


    public void performDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("The divisor cannot be equal to zero");
        }
        if (dividend < divisor) {
            throw new IllegalArgumentException("The dividend cannot be less than the divisor");
        }

        RenderDivision renderDivision = new RenderDivision(dividend, divisor);
        renderDivision.renderDivisionResult();

    }
}
