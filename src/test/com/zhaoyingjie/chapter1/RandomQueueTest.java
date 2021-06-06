package com.zhaoyingjie.chapter1;

import edu.princeton.cs.algs4.StdOut;

public class RandomQueueTest {
    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int j = 0; j < 3; j++) {
            for (Integer item : queue) {
                StdOut.print(item + " ");
            }
            StdOut.println();
        }
    }
}
