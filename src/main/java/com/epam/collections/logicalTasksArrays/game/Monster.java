package com.epam.collections.logicalTasksArrays.game;

import static com.epam.collections.logicalTasksArrays.game.Const.*;

public class Monster extends Door {
    public Monster() {
        power = RANDOM.nextInt(MAX_MONSTER_POWER - MIN_MONSTER_POWER) + MIN_MONSTER_POWER + 1;
    }

    @Override
    public String toString() {
        return "Monster {" +
                "power=" + power +
                '}';
    }
}
