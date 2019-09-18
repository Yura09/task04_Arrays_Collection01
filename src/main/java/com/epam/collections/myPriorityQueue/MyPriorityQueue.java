package com.epam.collections.myPriorityQueue;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class MyPriorityQueue<E> extends AbstractQueue<E> {
    private E[] array;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private final Comparator<? super E> comparator;
    /**
     * The number of elements in the priority queue.
     */
    private int size = 0;

    public MyPriorityQueue(int initialCapacity,
                           Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.array = (E[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    public MyPriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public MyPriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }


    private MyPriorityQueue(Comparator<? super E> comparator) {

        this.comparator = comparator;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
    public void print(){
        Stream<E> stream = Arrays.stream(array);
        stream.limit(size).forEach(System.out::println);
    }
    public boolean add(E e) {
        if (offer(e))
            return true;
        else
            throw new IllegalStateException("Queue full");
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }


    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        int i = size;
        if (i >= array.length) {
            int newCapacity = array.length + (array.length >> 1);
            array = Arrays.copyOf(array, newCapacity);
        }
        size = i + 1;
        if (i == 0)
            array[0] = e;
        else
            siftUp(i, e);
        return true;

    }

    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            E e = array[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = (E) key;
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            E e = array[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = x;
    }


    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E element = array[0];

        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        --size;

        return element;
    }

    @Override
    public E peek() {
        return (size == 0) ? null : array[0];
    }
}
