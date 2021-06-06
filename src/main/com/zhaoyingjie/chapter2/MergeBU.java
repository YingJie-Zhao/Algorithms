package com.zhaoyingjie.chapter2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings("rawtypes")
public class MergeBU extends AbstractSort {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int k = lo, j = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (k > mid) {
                a[i] = aux[j++];
            } else if (j > hi) {
                a[i] = aux[k++];
            } else if (less(aux[j], aux[k])) {
                a[i] = aux[j++];
            } else {
                a[i] = aux[k++];
            }
        }
    }

    public static void draw(Comparable[] a) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.CYAN);
//        StdDraw.text(0.5, 0.8, "MergeBU ----- 下边界:" + lo + " 上边界: " + hi);
        StdDraw.setPenRadius(0.005);
        StdDraw.setYscale();
        for (int i = 0; i < a.length; i++) {
//            if (lo <= i && i <= hi) {
//                StdDraw.setPenColor(Color.RED);
//            } else {
//                StdDraw.setPenColor(Color.LIGHT_GRAY);
//            }
            StdDraw.line(0.1 + i * 0.005, 0.1, 0.1 + i * 0.005, (Double) a[i] / 2 + 0.1);
        }
    }

    public static void sort(Comparable[] a) throws InterruptedException {
        int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz += sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
            draw(a);
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StdDraw.setCanvasSize(1700, 600);
        List<Double> listA = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            listA.add(Math.abs(StdRandom.uniform()));
        }
        Double[] a = listA.toArray(new Double[0]);
        sort(a);
    }
}
