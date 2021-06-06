package com.zhaoyingjie.chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class JosephusProblem {
    public static void main(String[] args) {
        int total = Integer.parseInt(args[0]);
        int maxFlag = Integer.parseInt(args[1]);
        if (total <= 0 || maxFlag <= 0) {
            return;
        }

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < total; i++) {
            queue.enqueue(i);
        }

        Queue<Integer> result = new Queue<>();
        int flag = 1;
        while (!queue.isEmpty()) {
            if (flag >= maxFlag) {
                result.enqueue(queue.dequeue());
                flag = 1;
            } else {
                queue.enqueue(queue.dequeue());
                flag++;
            }
        }
        for (Integer id : result) {
            StdOut.printf("%d ", id);
        }
    }
}
