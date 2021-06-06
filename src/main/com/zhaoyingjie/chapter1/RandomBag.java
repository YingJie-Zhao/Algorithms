package com.zhaoyingjie.chapter1;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhaoyingjie
 */
@SuppressWarnings("unchecked")
public class RandomBag<T> implements Iterable<T> {
    private T[] items = (T[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return 0 == n;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        if (isFull()) {
            resize(n * 2);
        }
        items[n++] = item;
    }

    private boolean isFull() {
        return items.length == n;
    }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {
        private int[] seq = new int[size()];
        private int index = 0;

        public RandomBagIterator() {
            for (int i = 0; i < size(); i++) {
                seq[i] = i;
            }
            StdRandom.shuffle(seq);
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return items[seq[index++]];
        }
    }
}
