package ru.belov.snakeapplication.controller;

import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Direction;
import ru.belov.snakeapplication.model.UnitPosition;
import ru.belov.snakeapplication.view.RunSnakeView;

public class RunSnakeController {

    private Direction direction = Direction.RIGHT;
    private UnitPosition unitPosition;

    public RunSnakeController(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
    }

    public void run(Scene scene, GridPane playingField, RunSnakeView view) {
        try {
            if (direction.equals(Direction.RIGHT)) {
                view.runRignt(playingField, unitPosition);
            } else if (direction.equals(Direction.LEFT)) {
                view.runLeft(playingField, unitPosition);
            } else if (direction.equals(Direction.DOWN)) {
                view.runDown(playingField, unitPosition);
            } else if (direction.equals(Direction.UP)) {
                view.runUp(playingField, unitPosition);
            }

            scene.setOnMousePressed(mouseEvent -> {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    switch (direction) {
                        case RIGHT:
                            direction = Direction.UP;
                            break;
                        case LEFT:
                            direction = Direction.DOWN;
                            break;
                        case UP:
                        case DOWN:
                            direction = Direction.LEFT;
                            break;
                    }
                }
                if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    switch (direction) {
                        case RIGHT:
                            direction = Direction.DOWN;
                            break;
                        case LEFT:
                            direction = Direction.UP;
                            break;
                        case UP:
                        case DOWN:
                            direction = Direction.RIGHT;
                            break;
                    }
                }
            });
        } catch (IllegalArgumentException exception) {
            view.checkPlayingField(playingField);
        }
    }

}
