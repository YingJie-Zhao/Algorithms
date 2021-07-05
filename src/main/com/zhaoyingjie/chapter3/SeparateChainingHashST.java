package com.zhaoyingjie.chapter3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoyingjie 2021/7/5
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }


    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M) {
        this.M = M;
        this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys() {
        List<Key> keys = new LinkedList<>();
        for (SequentialSearchST<Key, Value> kvST : st) {
            keys.addAll((List<Key>) kvST.keys());
        }
        return keys;
    }
}
