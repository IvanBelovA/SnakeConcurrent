package ru.belov.snakeapplication.view;

import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.UnitPosition;

public class RedFrogView extends RunFrog {

    @Override
    public void setPosition(UnitPosition unitPosition, Frog frog) {
        unitPosition.setRedFrogPositionX(frog.getPositionX());
        unitPosition.setRedFrogPositionY(frog.getPositionY());
    }

    @Override
    public void checkEat(UnitPosition unitPosition, Frog frog, GridPane playingField) {
        if (unitPosition.getRedFrogPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getRedFrogPositionY() == unitPosition.getHeadPositionY()) {
            newFrog(playingField, frog);
        }
    }
}
