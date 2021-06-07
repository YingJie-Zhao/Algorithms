package com.zhaoyingjie.chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class QuickSort extends AbstractSort {

    private static final List<Integer> midAnchors = new LinkedList<>();

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        midAnchors.add(j);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
            draw(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void draw(Comparable[] a, int l, int r) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenRadius(0.010);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < a.length; i++) {
            double x0 = 0.01 + i * 0.005;
            double y0 = 0.1;
            double x1 = 0.01 + i * 0.005;
            double y1 = (Double) a[i] / 2 + 0.1;
            if (i == l) {
                StdDraw.setPenColor(Color.RED);
            } else if (i == r) {
                StdDraw.setPenColor(Color.GREEN);
            } else if (midAnchors.contains(i)) {
                StdDraw.setPenColor(Color.YELLOW);
            } else {
                StdDraw.setPenColor(Color.DARK_GRAY);
            }
            StdDraw.line(x0, y0, x1, y1);
        }
        StdDraw.show();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            StdOut.println(e.getMessage());
        }
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
