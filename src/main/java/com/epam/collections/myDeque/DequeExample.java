package com.epam.collections.myDeque;

public class DequeExample {

    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>(2);
        myDeque.addFirst(1);
        myDeque.addLast(3);
        myDeque.addFirst(2);
        myDeque.addFirst(116);
        myDeque.addFirst(1);
        System.out.println(myDeque.remove(116));
        System.out.println(myDeque.contains(7));
        myDeque.print();
        System.out.println("-------------");
        myDeque.clear();
        System.out.println(myDeque.isEmpty());
    }
}
