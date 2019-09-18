package com.epam.collections.myDeque;

import com.sun.istack.internal.NotNull;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<Type> implements Deque<Type> {

    private Type[] array;
    private int head;
    private int tail;
    private int capacity;


    public MyDeque() {
        capacity = 10;
        array = (Type[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    public MyDeque(int capacity) {
        array = (Type[]) new Object[capacity];
        this.capacity = capacity;
        tail = head = 0;

    }

    public void print() {
        for (int i = 0; i < tail; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public void addFirst(Type type) {
        // ++tail;
        if (tail == capacity) {
            resize();
        }
        ++tail;
        if (tail > 1) {
            for (int i = tail - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
        }
        array[head] = type;
    }

    @Override
    public void addLast(Type type) {
        if (tail == capacity) {
            resize();
        }
        array[tail++] = type;
    }

    @Override
    public boolean offerFirst(Type type) {
        return false;
    }

    @Override
    public boolean offerLast(Type type) {
        return false;
    }

    private void resize() {
        Type[] tmp = array;
        this.capacity *= 2;
        array = (Type[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            array[i] = tmp[i];
        }
    }

    @Override
    public Type removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deck is already empty!");
        Type element = array[head];
        for (int i = 0; i < tail; i++) {
            array[i] = array[i + 1];
        }
        tail--;
        return element;
    }

    @Override
    public Type removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deck is already empty!");
        Type element = array[--tail];
        array[tail] = null;
        // tail--;
        return element;
    }

    @Override
    public Type pollFirst() {
        return null;
    }

    @Override
    public Type pollLast() {
        return null;
    }


    @Override
    public Type getFirst() {
        Type result = array[head];
        if (result == null) {
            throw new NoSuchElementException("Deck is already empty!");
        }
        return result;

    }

    @Override
    public Type getLast() {
        Type result = array[tail - 1];
        if (result == null) {
            throw new NoSuchElementException("Deck is already empty!");
        }
        return result;
    }

    @Override
    public Type peekFirst() {
        return array[head];
    }

    @Override
    public Type peekLast() {
        return array[tail - 1];
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(@NotNull Type type) {
        addLast(type);
        return true;
    }

    @Override
    public boolean offer(Type type) {
        return false;
    }

    @Override
    @NotNull
    public Type remove() {
        return removeFirst();
    }

    @Override
    public Type poll() {
        return null;
    }


    @Override
    public Type element() {
        return null;
    }

    @Override
    public Type peek() {
        return null;
    }


    @Override
    public void push(Type type) {

    }

    @Override
    public Type pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        Type t = (Type) o;
        int count = 0;
        for (int i = 0; i < tail; i++) {
            if (o.equals(array[i])) {
                t = array[i] = null;

                count = i;
            }
        }
        if (t == null) {
            for (int i = count; i < tail; i++) {
                array[i] = array[i + 1];
            }
            tail--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Type> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < tail; i++) {
            array[i] = null;
        }
        tail = head = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < tail; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return tail == 0;
    }

    @Override
    public Iterator<Type> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<Type> descendingIterator() {
        return null;
    }


}
