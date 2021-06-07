package com.zhaoyingjie.chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings("unchecked")
public class RandomQueue<T> implements Iterable<T> {
    private T[] items = (T[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return 0 == n;
    }

    public void enqueue(T t) {
        if (n == items.length) {
            resize(2 * n);
        }
        items[n++] = t;
    }

    public void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T temp;
        if (1 == n) {
            temp = items[1];
            items[1] = null;
            n--;
            return temp;
        }
        int randomIndex = StdRandom.uniform(n - 1);
        temp = items[randomIndex];
        items[randomIndex] = items[--n];
        items[n] = null;
        if (!isEmpty() && n == items.length / 4) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T sample() {
        return items[StdRandom.uniform(n)];
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<T> {
        private int[] seq = new int[n];
        private int index = 0;

        public RandomQueueIterator() {
            for (int i = 0; i < n; i++) {
                seq[i] = i;
            }
            StdRandom.shuffle(seq);
        }

        @Override
        public boolean hasNext() {
            return index < n;
        }

        @Override
        public T next() {
            return items[seq[index++]];
        }
    }

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
