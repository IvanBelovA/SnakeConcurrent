package ru.belov.snakeapplication.view;

import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.UnitPosition;

public class BlueFrogView extends RunFrog {

    @Override
    public void setPosition(UnitPosition unitPosition, Frog frog) {
        unitPosition.setBlueFrogPositionX(frog.getPositionX());
        unitPosition.setBlueFrogPositionY(frog.getPositionY());
    }

    @Override
    public void checkEat(UnitPosition unitPosition, Frog frog, GridPane playingField) {
        if (unitPosition.getBlueFrogPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getBlueFrogPositionY() == unitPosition.getHeadPositionY()) {
            newFrog(playingField, frog);
        }
    }
}
