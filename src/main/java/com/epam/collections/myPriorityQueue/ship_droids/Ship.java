package com.epam.collections.myPriorityQueue.ship_droids;

import java.util.ArrayList;
import java.util.List;

public class Ship<T extends Droid> {

    public boolean findMilitaryDroid(List<? super MiniMilitaryDroid> droids, MilitaryDroid militaryDroid) {
        for (Object droid : droids) {
            if (droid.equals(militaryDroid)) {
                System.out.println(droid);
                return true;
            }
        }
        return false;
    }

    public void printMilitaryDroids(List<? super MiniMilitaryDroid> list) {
            for (Object droid : list) {
            System.out.println(droid);
        }
    }

    public List<? super T> getMilitaryDroids(List<? extends T> droidList) {

        List<? super T> militaryDroids = new ArrayList<>();
        for (T droid : droidList) {
            if (droid instanceof MilitaryDroid) {
                militaryDroids.add(droid);
            }
        }
        return militaryDroids;
    }



}
