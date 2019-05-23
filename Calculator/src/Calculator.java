//Calculator

import java.util.Scanner;

public class Calculator {
    Calculator() {
    }

    public int add(int addend1, int addend2) {
        return addend1 + addend2;
    }

    public int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public int multiply(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    public int divide(int divisible , int divider ) {
        if (divider == 0) {
            System.out.println("Error! Dividing by zero is not allowed.");
            return 0;

        } else {
            return divisible / divider;
        }
    }

    public int modulo(int divisible, int divider) {
        if (divider == 0) {
            System.out.println("Error! Dividing by zero is not allowed.");
            return 0;
        } else {
            return divisible % divider;
        }
    }

    public int inputNumber() {
        int number;
        System.out.println("Please input number: ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        return number;

    }

    public int inputOperation() {
        int operationNumber;
        System.out.println("Please select operation: 1 - add, 2 - subtract, 3 - multiply, 4 - divide, 5 - modulo");
        Scanner sc = new Scanner(System.in);
        operationNumber = sc.nextInt();
        return operationNumber;
    }


    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        int number1, number2, operation;
        number1 = myCalculator.inputNumber();
        number2 = myCalculator.inputNumber();
        operation = myCalculator.inputOperation();
        calculate(myCalculator, number1, number2, operation);
    }

    private static void calculate(Calculator myCalculator, int number1, int number2, int operation) {
        int result;
        switch (operation) {
            case 1:
                result = myCalculator.add(number1, number2);
                System.out.println("Your result is: " + result);
                break;
            case 2:
                result = myCalculator.subtract(number1, number2);
                System.out.println("Your result is: " + result);
                break;
            case 3:
                result = myCalculator.multiply(number1, number2);
                System.out.println("Your result is: " + result);
                break;
            case 4:
                result = myCalculator.divide(number1, number2);
                System.out.println("Your result is: " + result);
                break;
            case 5:
                result = myCalculator.modulo(number1, number2);
                System.out.println("Your result is: " + result);
                break;
            default:
                System.out.println("You didn't specify operation");
                break;

        }
    }
}
