package ru.belov.snakeapplication.model;

import java.util.Random;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction generateRandomDirection() {
        Direction[] values = Direction.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
