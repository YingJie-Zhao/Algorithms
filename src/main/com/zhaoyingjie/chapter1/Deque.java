package com.zhaoyingjie.chapter1;

import java.util.Iterator;

/**
 * @author zhaoyingjie
 */
public class Deque<Item> implements Iterable<Item> {

    private DoubleNode left;
    private DoubleNode right;
    private int size;

    private class DoubleNode {
        private DoubleNode pre;
        private DoubleNode next;
        private Item item;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        DoubleNode newLeft = new DoubleNode();
        newLeft.item = item;
        if (isEmpty()) {
            left = right = newLeft;
        } else {
            newLeft.next = left;
            left.pre = newLeft;
            left = newLeft;
        }
        size++;
    }

    public void pushRight(Item item) {
        DoubleNode newRight = new DoubleNode();
        newRight.item = item;
        if (isEmpty()) {
            left = right = newRight;
        } else {
            newRight.pre = right;
            right.next = newRight;
            right = newRight;
        }
        size++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode leftNode = left;
        left.pre = null;
        left = left.next;
        size--;
        return leftNode.item;
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode rightNode = right;
        right.next = null;
        right = right.pre;
        size--;
        return rightNode.item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private DoubleNode current = left;

        @Override
        public boolean hasNext() {
            return null != current;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
