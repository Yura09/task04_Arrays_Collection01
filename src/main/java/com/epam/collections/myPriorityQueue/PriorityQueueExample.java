package com.epam.collections.myPriorityQueue;

import com.epam.collections.myPriorityQueue.ship_droids.Droid;
import com.epam.collections.myPriorityQueue.ship_droids.MilitaryDroid;

import java.util.Comparator;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Comparator<Droid> comparator = Comparator.comparingInt(Droid::getSpeed);
        MyPriorityQueue<MilitaryDroid> priorityQueue = new MyPriorityQueue<>(10, comparator);
        priorityQueue.add(new MilitaryDroid("M20", 22, 12));
        priorityQueue.add(new MilitaryDroid("M30", 20, 12));
        System.out.println(priorityQueue.peek()+"\n");
        priorityQueue.print();

    }
}
