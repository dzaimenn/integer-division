package foxminded.dzaimenko.intdivision;

import java.util.Scanner;

public class IntegerDivision {
    private int dividend;
    private int divisor;
    private int divisionResult;

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getDivisionResult() {
        return divisionResult;
    }

    private void initDividend(Scanner scanner) {

        while (true) {
            System.out.println("Please enter the integer dividend:");

            if (!scanner.hasNextInt()) {
                System.out.println("The entered number is not an integer");
                scanner.next();
            } else {
                dividend = Math.abs(scanner.nextInt());
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
                int potentialDivisor = scanner.nextInt();

                if (dividend < potentialDivisor) {
                    System.out.println("The divisor must not be greater than the dividend");
                } else {
                    divisor = Math.abs(potentialDivisor);

                    if (divisor == 0) {
                        System.out.println("The divisor cannot be equal to zero");
                    } else {
                        break;
                    }
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
        System.out.println();

    }
}
