package com.lidiabazhenova.common;

import java.awt.*;
import javax.swing.*;


public class DrowGraph extends JPanel {

    static int x1 = 37, y1 = 235, x2 = 63, y2 = 22; // координаты точек 1-го отрезка
    static int x3 = 184, y3 = 120, x4 = 34, y4 = 87; // координаты точек 2-го отрезка
    static int X = 0, Y = 0;
    static String X1;


    public DrowGraph(){

        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.getContentPane().add(this);

        jf.setVisible(true);
        jf.repaint();

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);



        g.drawLine(x1, y1, x2, y2);

        g.drawLine(x3, y3, x4, y4);

        g.setColor(Color.black);
        g.drawString(X1, 10, 10);

    }

    public static void main(String args[]){
        DrowGraph dr = new DrowGraph();
        //построение векторов
        int v1, v2, v3, v4;
        int xv12, xv13, xv14, xv31, xv32, xv34, yv12, yv13, yv14, yv31, yv32, yv34;
        //нахождение координат векторов
        xv12 = x2 - x1;		xv13 = x3 - x1;		xv14 = x4 - x1;
        yv12 = y2 - y1;		yv13 = y3 - y1;		yv14 = y4 - y1;

        xv31 = x1 - x3;		xv32 = x2 - x3;		xv34 = x4 - x3;
        yv31 = y1 - y3;		yv32 = y2 - y3;		yv34 = y4 - y3;

        // векторные произведения

        v1 = xv34 * yv31 - yv34 * xv31;
        v2 = xv34 * yv32 - yv34 * xv32;
        v3 = xv12 * yv13 - yv12 * xv13;
        v4 = xv12 * yv14 - yv12 * xv14;

        if((v1 * v2) < 0 && (v3 * v4) < 0){
            int A1, B1, C1, A2, B2, C2;
            A1 = y2 - y1;
            A2 = y4 - y3;
            B1 = x1 - x2;
            B2 = x3 - x4;
            C1 = (x1 * (y1 - y2) + y1 * (x2 - x1)) * (-1);
            C2 = (x3 * (y3 - y4) + y3 * (x4 - x3)) * (-1);


            double D = (double) ((A1 * B2) - (B1 * A2));
            double Dx = (double) ((C1 * B2) - (B1 * C2));
            double Dy = (double) ((A1 * C2) - (C1 * A2));

            if(D != 0){
                X = (int) (Dx / D);
                Y = (int) (Dy / D);
                X1 = "Отрезки пересекаются в точке: " + X + ", " + Y;


                dr.repaint();
            }
        }
        else X1 = "Отрезки не пересекаются ";
    }
}
