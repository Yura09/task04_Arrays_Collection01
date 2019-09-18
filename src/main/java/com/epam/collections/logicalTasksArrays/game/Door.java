package com.epam.collections.logicalTasksArrays.game;

public class Door {
    int power;


    public int getPower() {
        return power;
    }

    public int givePower(Hero hero) {
        //power = RANDOM.nextInt(MAX_ARTIFACT_POWER - MIN_ARTIFACT_POWER) + MIN_ARTIFACT_POWER + 1;
        hero.setHeroPower(power + hero.getHeroPower());
        return power;
    }

    public int reducePower() {
        //  power = RANDOM.nextInt(MAX_MONSTER_POWER - MIN_MONSTER_POWER) + MIN_MONSTER_POWER + 1;
        power = 0;
        return power;

    }


}
