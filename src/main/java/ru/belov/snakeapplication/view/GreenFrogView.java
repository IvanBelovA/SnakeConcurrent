package ru.belov.snakeapplication.view;

import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.UnitPosition;

public class GreenFrogView extends RunFrog {

    @Override
    public void setPosition(UnitPosition unitPosition, Frog frog) {
        unitPosition.setFrogGreenPositionY(frog.getPositionY());
        unitPosition.setFrogGreenPositionX(frog.getPositionX());
    }

    @Override
    public void checkEat(UnitPosition unitPosition, Frog frog, GridPane playingField) {
        if (unitPosition.getFrogGreenPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getFrogGreenPositionY() == unitPosition.getHeadPositionY()) {
            newFrog(playingField, frog);
        }
    }
}
