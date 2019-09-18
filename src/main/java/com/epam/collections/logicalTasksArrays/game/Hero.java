package com.epam.collections.logicalTasksArrays.game;


import static com.epam.collections.logicalTasksArrays.game.Const.HERO_POWER;

public class Hero {
    private int heroPower;


    public Hero() {
        heroPower = HERO_POWER;
    }

    public int getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(int heroPower) {
        this.heroPower = heroPower;
    }
}
