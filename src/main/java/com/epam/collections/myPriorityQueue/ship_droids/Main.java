package com.epam.collections.myPriorityQueue.ship_droids;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
     List<Droid> droids= Arrays.asList(new MilitaryDroid("M23",100,20),new HelperDroid("WASH",20,true));
     Ship<Droid>ship=new Ship<>();
     List<? super Droid> list=ship.getMilitaryDroids(droids);
        System.out.println(list);
        System.out.println(ship.findMilitaryDroid(droids,new MiniMilitaryDroid("M23",10,20)));
    }
}
