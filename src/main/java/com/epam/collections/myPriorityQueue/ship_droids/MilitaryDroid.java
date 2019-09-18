package com.epam.collections.myPriorityQueue.ship_droids;

import java.util.Objects;

public class MilitaryDroid extends Droid {
    private int damage;

    public MilitaryDroid(String name, int speed, int damage) {
        super(name, speed);
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryDroid)) return false;
        if (!super.equals(o)) return false;
        MilitaryDroid that = (MilitaryDroid) o;
        return damage == that.damage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage);
    }

    @Override
    public String toString() {
        return "MilitaryDroid{" + super.toString().replaceAll("Droid", "") +
                "damage=" + damage +
                '}';
    }
}
