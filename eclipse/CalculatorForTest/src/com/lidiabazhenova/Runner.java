package com.lidiabazhenova;

import com.sun.media.sound.SoftAudioProcessor;

import java.util.Scanner;

public class Runner {
    final static String ADDITION = "+";
    final static String SUBSTRACTION = "-";
    final static String MULTIPLICATION = "*";
    final static String DIVISION = "/";


    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String exit = "no";
        Scanner scanner = new Scanner(System.in);
        while (!exit.equals("yes")) {
            calculator.cleanResult();
            System.out.println("Enter first arg");
            double first = Double.valueOf(scanner.next());

            System.out.println("Enter second arg");
            double second = Double.valueOf(scanner.next());

            System.out.println("Choose the operation: +, -, *, /");
            String operation = scanner.next();
            switch (operation) {
                case ADDITION:
                    calculator.add(first, second);
                    break;
                case SUBSTRACTION:
                    calculator.sub(first, second);
                    break;
                case MULTIPLICATION:
                    calculator.mul(first, second);
                    break;
                case DIVISION:
                    calculator.div(first, second);
                    break;
            }
            System.out.println("result = " + calculator.getResult());

            System.out.println("Exit? : yes/no");
            exit = scanner.next();
        }
         System.exit(0);
    }
}
