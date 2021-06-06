package com.zhaoyingjie.chapter2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Merge {

    private static Comparable[] aux;

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) throws InterruptedException {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) throws InterruptedException {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
        draw(a, lo, hi);
        Thread.sleep(200);
    }

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

    public static void draw(Comparable[] a, int lo, int hi) {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.CYAN);
        StdDraw.text(0.5, 0.8, "下边界:" + lo + " 上边界: " + hi);
        StdDraw.setPenRadius(0.005);
        StdDraw.setYscale();
        for (int i = 0; i < a.length; i++) {
            if (lo <= i && i < hi) {
                StdDraw.setPenColor(Color.RED);
            } else {
                StdDraw.setPenColor(Color.LIGHT_GRAY);
            }
            StdDraw.line(0.1 + i * 0.005, 0.1, 0.1 + i * 0.005, (Double) a[i] / 2 + 0.1);
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
