package com.zhaoyingjie.chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings({"rawtypes"})
public class Selection extends AbstractSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            draw(a, i - 1, min);
            exchange(a, i, min);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void draw(Comparable[] a, int currentP, int selectedP) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenRadius(0.010);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < a.length; i++) {
            double x0 = 0.01 + i * 0.005;
            double y0 = 0.1;
            double x1 = 0.01 + i * 0.005;
            double y1 = (Double) a[i] / 2 + 0.1;
            if (i == selectedP) {
                StdDraw.setPenColor(Color.RED);
            } else if (i <= currentP) {
                StdDraw.setPenColor(Color.cyan);
            } else {
                StdDraw.setPenColor(Color.DARK_GRAY);
            }
            StdDraw.line(x0, y0, x1, y1);
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(2200, 600);
        List<Double> listA = new LinkedList<>();
        for (int i = 0; i < 180; i++) {
            listA.add(Math.abs(StdRandom.uniform()));
        }
        Double[] a = listA.toArray(new Double[0]);
        sort(a);
    }
}
