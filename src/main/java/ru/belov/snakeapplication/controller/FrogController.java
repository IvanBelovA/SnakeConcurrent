package ru.belov.snakeapplication.controller;

import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Direction;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.UnitPosition;
import ru.belov.snakeapplication.view.RunFrog;

public class FrogController {

    private Direction direction;
    private UnitPosition unitPosition;

    public FrogController(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
    }

    public void runFrog(GridPane playingField, RunFrog view, Frog frog) {
        try {
            direction = Direction.generateRandomDirection();

            if (direction.equals(Direction.RIGHT)) {
                view.runRignt(playingField, unitPosition, frog);
            } else if (direction.equals(Direction.LEFT)) {
                view.runLeft(playingField, unitPosition, frog);
            } else if (direction.equals(Direction.DOWN)) {
                view.runDown(playingField, unitPosition, frog);
            } else if (direction.equals(Direction.UP)) {
                view.runUp(playingField, unitPosition, frog);
            }
        } catch (IllegalArgumentException exception) {
            view.getNewPosition(playingField, frog);
        }
    }
}
