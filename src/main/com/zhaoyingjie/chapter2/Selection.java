package com.zhaoyingjie.chapter2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings({"rawtypes"})
public class Selection extends AbstractSort {

    public static void sort(Comparable[] a) throws InterruptedException {
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
            Thread.sleep(200);
        }
    }

    public static void draw(Comparable[] a, int currentP, int selectedP) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.setYscale();
        for (int i = 0; i < a.length; i++) {
            if (i == selectedP) {
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
