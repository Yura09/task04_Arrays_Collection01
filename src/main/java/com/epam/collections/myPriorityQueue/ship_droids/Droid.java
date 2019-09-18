package com.epam.collections.myPriorityQueue.ship_droids;

import java.util.Objects;

public class Droid implements Comparable<Droid> {
    private String name;
    private int speed;

    public Droid(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Droid)) return false;
        Droid droid = (Droid) o;
        return speed == droid.speed &&
                Objects.equals(name, droid.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed);
    }

    @Override
    public String toString() {
        return "Droid" +
                "name='" + name + '\'' +
                ", speed=" + speed+" ";
    }

    @Override
    public int compareTo(Droid o) {
        return name.compareTo(o.getName());
    }
}
