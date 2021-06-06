package com.zhaoyingjie.chapter2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class AbstractSort {

    public static void show(Comparable[] a) {
        for (Comparable e : a) {
            StdOut.print(e + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
