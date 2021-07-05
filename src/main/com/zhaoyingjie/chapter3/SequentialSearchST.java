package com.zhaoyingjie.chapter3;

import java.util.LinkedList;
import java.util.List;

public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public Iterable<Key> keys() {
        List<Key> keys = new LinkedList<>();
        Node p = this.first;
        while (null != p) {
            keys.add(p.key);
            p = p.next;
        }
        return keys;
    }
}
