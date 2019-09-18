package com.epam.collections.myPriorityQueue.ship_droids;

import java.util.Objects;

public class HelperDroid extends Droid {
    private boolean help;
    public HelperDroid(String name, int speed,boolean help) {
        super(name, speed);
        this.help=help;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HelperDroid)) return false;
        if (!super.equals(o)) return false;
        HelperDroid that = (HelperDroid) o;
        return help == that.help;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), help);
    }

    @Override
    public String toString() {
        return "HelperDroid";
    }
}
