package foxminded.dzaimenko.intdivision;

import java.util.Scanner;

public class IntegerDivisor {
    private int dividend;
    private int divisor;
    private int divisionResult;

    private void initDividend(Scanner scanner) {

        while (true) {
            System.out.println("Please enter the integer dividend:");

            if (!scanner.hasNextInt()) {
                System.out.println("The entered number is not an integer");
                scanner.next();
            } else {
                dividend = scanner.nextInt();
                break;
            }
        }
    }

    private void initDivisor(Scanner scanner) {

        while (true) {
            System.out.println("Please enter the integer divisor:");

            if (!scanner.hasNextInt()) {
                System.out.println("The entered number is not an integer");
                scanner.next();
            } else {
                divisor = scanner.nextInt();
                if (divisor == 0) {
                    System.out.println("The divisor cannot be equal to zero");
                } else {
                    break;
                }
            }
        }
    }

    private void initDivisionResult() {
        divisionResult = dividend / divisor;
    }

    public void performDivision() {
        Scanner scanner = new Scanner(System.in);

        initDividend(scanner);
        initDivisor(scanner);
        initDivisionResult();

        scanner.close();

        System.out.println("Result of the division: ");
        System.out.println(divisionResult);
    }
}
