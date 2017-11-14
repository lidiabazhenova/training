package com.lidiabazhenova;

public class Calculator {
    private double result;


    public double add(double arg1, double arg2) {
        result = arg1 + arg2;
        return result;
    }

    public double sub(double arg1, double arg2) {
        result = arg1 - arg2;
        return result;
    }

    public double mul(double arg1, double arg2) {
        result = arg1 * arg2;
        return result;
    }

    public double div(double arg1, double arg2) {
        result = arg1 / arg2;
        return result;
    }

    public double getResult() {
        return result;
    }

    public double cleanResult() {
        return 0;
    }

}
