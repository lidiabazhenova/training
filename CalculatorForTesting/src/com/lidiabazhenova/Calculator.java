package com.lidiabazhenova;

public class Calculator {
    final static String ADDITION = "+";
    final static String SUBSTRACTION = "-";
    final static String MULTIPLICATION = "*";
    final static String DIVISION = "/";

    private double result;

    public Calculator() {
    }

    public Calculator(double result) {
        this.result = result;
    }

    public double add(double arg1, double arg2) {
        return arg1 + arg2;
    }

    public double sub(double arg1, double arg2) {
        return arg1 - arg2;
    }

    public double mul(double arg1, double arg2) throws UserException{
        if ((arg1==Double.MAX_VALUE)||(arg1==Double.MAX_VALUE))

                throw new UserException("error");

        else {
        return arg1 * arg2;}
    }

    public double div(double arg1, double arg2) throws UserException {
        if (arg2 != 0) {
            return arg1 / arg2;
        } else
            throw new UserException("division by 0");
    }

    public void setResult(String operation, double first, double second) {
        this.result = doOperation(operation, first, second);
        viewResult(operation, first, second, this.result);
    }

    public double getResult() {
        return result;
    }

    public void cleanResult() {
        result = 0;
    }

    public double doOperation(String operation, double first, double second) {
        switch (operation) {
            case ADDITION:
                return add(first, second);
            case SUBSTRACTION:
                return sub(first, second);
            case MULTIPLICATION:
                try {
                return mul(first, second);
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please, try again with correct numbers");
                    return 0;
                }
            case DIVISION:
                try {
                    return div(first, second);
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please, try again with correct numbers");
                }
        }
        return 0;
    }

    public void viewResult(String operation, double arg1, double arg2, double myResult) {
        System.out.println(arg1 + " " + operation + " " + arg2 + " = " + myResult);
    }
}
