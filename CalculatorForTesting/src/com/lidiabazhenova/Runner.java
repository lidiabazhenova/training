package com.lidiabazhenova;

import java.io.IOException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException {
        double first;
        double second;
        String operation;
        Calculator calculator = new Calculator();
        String exit = "";
        Scanner scanner = new Scanner(System.in);

        while (!exit.equals("e")) {
            try {
                calculator.cleanResult();
                System.out.println("Enter first arg");
                first = Double.valueOf(scanner.next());
                System.out.println("Choose the operation: +, -, *, / ");
                operation = scanner.next();
                if ((operation.equals("+")) || (operation.equals("-")) || (operation.equals("*"))
                        || (operation.equals("/"))) {
                    System.out.println("Enter second arg");
                    second = Double.valueOf(scanner.next());

                    calculator.setResult(operation, first, second);

                    System.out.println("'e' for exit or 's' for saving info or 'c' for continue");
                    exit = scanner.next();
                    if (exit.equals("s")) {
                        Info info = new Info(operation, first, second, calculator.getResult());
                        info.write();

                        System.out.println("'e' for exit or 'c' for continue");
                        exit = scanner.next();
                    }
                } else try {
                    throw new UserException("don't correct operation");
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please, try again with correct operation");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please, try again with correct args");
            }
        }
        System.exit(0);
    }
}
