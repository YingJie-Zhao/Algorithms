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
public class Shell extends AbstractSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
            draw(a);
        }
    }

    public static void draw(Comparable[] a) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        for (int i = 0; i < a.length; i++) {
            StdDraw.line(0.01 + i * 0.005, 0.1, 0.01 + i * 0.005, (Double) a[i] / 2 + 0.1);
        }
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1700, 600);
        List<Double> listA = new LinkedList<>();
        for (int i = 0; i < 180; i++) {
            listA.add(Math.abs(StdRandom.uniform()));
        }
        Double[] a = listA.toArray(new Double[0]);
        sort(a);
    }
}
