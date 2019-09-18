package com.epam.collections.logicalTasksArrays.game;


import static com.epam.collections.logicalTasksArrays.game.Const.NUMBER_OF_DOORS;
import static com.epam.collections.logicalTasksArrays.game.Const.RANDOM;

public class Arena {
    private static Hero hero = new Hero();

    public static void main(String[] args) {
        Door[] doors = new Door[NUMBER_OF_DOORS];
        fillUpDoor(doors);
        printDoors(doors);
        System.out.println(countHowManyDoorsCanKill(doors) + " doors can kill you");
        System.out.println("-------------------------\n");
        findWay(doors);
    }

    public static Door[] fillUpDoor(Door[] doors) {
        for (int i = 0; i < doors.length; i++) {
            if (RANDOM.nextDouble() < 0.5) {
                doors[i] = generateArtifact();
            } else {
                doors[i] = generateMonster();
            }
        }
        return doors;
    }

    public static void printDoors(Door[] doors) {
        for (Door door : doors) {
            System.out.println(door);
        }
    }


    public static Monster generateMonster() {
        return new Monster();
    }

    public static MagicArtifact generateArtifact() {
        return new MagicArtifact();
    }

    public static int countHowManyDoorsCanKill(Door[] doors) {
        int count = 0;
        for (Door door : doors) {
            if (door instanceof Monster && door.getPower() > hero.getHeroPower()) {
                count++;
            }
        }
        return count;
    }

    public static void findWay(Door[] doors) {
        int i = 0;
        int count = 0;
        GAME:
        while (true) {
            for (Door door : doors) {
                i++;
                if (door instanceof MagicArtifact && door.getPower() != 0) {
                    System.out.println("door N " + i + " you will get artifact with power: " + door.getPower());
                    door.givePower(hero);
                    door.reducePower();
                } else if (door instanceof Monster && door.getPower() != 0){
                    if (hero.getHeroPower() < door.getPower()) {
                        System.out.println("you haven't enough power: " + hero.getHeroPower());

                    } else {
                        System.out.println("door N " + i + " you killed monster, your power: " + hero.getHeroPower());
                        door.reducePower();
                    }
                }
            }
            if (checkAllDoors(doors)) {
                i = 0;
                ++count;
                if (count >= 2) {
                    System.out.println("you can't win");
                    break;
                }
            } else {
                System.out.println("end of the game you win");
                break;
            }
        }
    }

    private static boolean checkAllDoors(Door[] doors) {
        for (Door door : doors) {
            if (door.getPower() != 0) {
                return true;
            }
        }
        return false;
    }
}
