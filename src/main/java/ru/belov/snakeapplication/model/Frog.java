package ru.belov.snakeapplication.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Frog {

    private static final int RADIUS = 20 / 2;

    private Circle circle;
    private int positionX;
    private int positionY;
    private Color color;

    public Frog(Circle circle, int startPositionX, int startPositionY, Color color) {
        circle.setRadius(RADIUS);
        circle.setFill(color);
        this.circle = circle;
        this.positionX = startPositionX;
        this.positionY = startPositionY;
        this.color = color;
    }

    public Circle getCircle() {
        return circle;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
