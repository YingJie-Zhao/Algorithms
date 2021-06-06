package com.zhaoyingjie.chapter2;

import java.awt.*;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings({"rawtypes"})
public class Insertion extends AbstractSort {

    public static void sort(Comparable[] a) throws InterruptedException {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
                draw(a, i, j - 1);
                Thread.sleep(200);
            }
        }
    }

    public static void draw(Comparable[] a, int currentP, int insertionP) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < a.length; i++) {
            if (i == insertionP) {
                StdDraw.setPenColor(Color.RED);
            } else if (i <= currentP) {
                StdDraw.setPenColor(Color.cyan);
            } else {
                StdDraw.setPenColor(Color.LIGHT_GRAY);
            }
            StdDraw.line(0.1 + i * 0.01, 0.1, 0.1 + i * 0.01, (Double) a[i] / 2 + 0.1);
        }
    }
}
