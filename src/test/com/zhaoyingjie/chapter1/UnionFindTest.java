package com.zhaoyingjie.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UnionFindTest {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        int n = StdIn.readInt();
        UnionFind uf = new UnionFind(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
        StdOut.printf("Cost: %f s\n", stopwatch.elapsedTime());
    }
}
