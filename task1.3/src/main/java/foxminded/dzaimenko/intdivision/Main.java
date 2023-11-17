package foxminded.dzaimenko.intdivision;

public class Main {
    public static void main(String[] args) {

        IntegerDivision integer = new IntegerDivision();
        integer.performDivision();

        RenderDivision render = new RenderDivision(integer.getDividend(), integer.getDivisor(), integer.getDivisionResult());
        render.renderDivisionResult();


    }
}