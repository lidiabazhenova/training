package com.lidiabazhenova.task22;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * На плоскости задано N отрезков. Найти точку пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap
 */
public class Task22Test {
    final static Map<Integer, Double> abscissa = new TreeMap<>();
    DecimalFormat df = new DecimalFormat("#.##");

    static int x1, y1, x2, y2;
    static int x3, y3, x4, y4;
    int countOfPairs = 0;

    @Test
    public void task22Test() {
        df.setRoundingMode(RoundingMode.CEILING);

        addCoordinates(37, 235, 63, 22, 184, 120, 34, 87);
        putInAbscissa();
        addCoordinates(47, 235, 73, 22, 184, 120, 34, 87);
        putInAbscissa();
        addCoordinates(47, 235, 73, 22, 47, 235, 73, 22);
        putInAbscissa();
        printMap(abscissa);
        getMin(abscissa);
    }

    public static void addCoordinates(int X1, int Y1, int X2, int Y2, int X3, int Y3, int X4, int Y4) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(X1, Y1, X2, Y2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(X3, Y3, X4, Y4));
        x1 = list1.get(0);
        y1 = list1.get(1);
        x2 = list1.get(2);
        y2 = list1.get(3);
        x3 = list2.get(0);
        y3 = list2.get(1);
        x4 = list2.get(2);
        y4 = list2.get(3);
    }

    private void printMap(Map<Integer, Double> map) {

        for (Map.Entry<Integer, Double> entry : map.entrySet()
                ) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private void putInAbscissa() {
        Double X = getX();
        if (X != null) {
            abscissa.put(++countOfPairs, X);
        }
    }

    private Double getX() {
        int v1, v2, v3, v4;
        int xv12, xv13, xv14, xv31, xv32, xv34, yv12, yv13, yv14, yv31, yv32, yv34;
        double Dx;
        double D;
        double X;

        xv12 = x2 - x1;
        xv13 = x3 - x1;
        xv14 = x4 - x1;
        yv12 = y2 - y1;
        yv13 = y3 - y1;
        yv14 = y4 - y1;

        xv31 = x1 - x3;
        xv32 = x2 - x3;
        xv34 = x4 - x3;
        yv31 = y1 - y3;
        yv32 = y2 - y3;
        yv34 = y4 - y3;

        v1 = xv34 * yv31 - yv34 * xv31;
        v2 = xv34 * yv32 - yv34 * xv32;
        v3 = xv12 * yv13 - yv12 * xv13;
        v4 = xv12 * yv14 - yv12 * xv14;

        if ((v1 * v2) < 0 && (v3 * v4) < 0) {
            int A1, B1, C1, A2, B2, C2;
            A1 = y2 - y1;
            A2 = y4 - y3;
            B1 = x1 - x2;
            B2 = x3 - x4;
            C1 = (x1 * (y1 - y2) + y1 * (x2 - x1)) * (-1);
            C2 = (x3 * (y3 - y4) + y3 * (x4 - x3)) * (-1);
            D = (double) ((A1 * B2) - (B1 * A2));
            Dx = (double) ((C1 * B2) - (B1 * C2));

            if (D != 0) {
                X = Dx / D;
                System.out.println("intersect; abscissa = " + df.format(X));

                return X;
            }
        } else System.out.println("do not intersect ");

        return null;
    }

    public void getMin(Map<Integer, Double> map) {
        Map.Entry<Integer, Double> min = null;

        if (map.size() > 0) {
            {
                for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                    if (min == null || min.getValue() > entry.getValue()) {
                        min = entry;
                    }
                }
                System.out.println(df.format(min.getValue()));
            }
        } else System.out.println("do not intersect in any case");
    }
}

