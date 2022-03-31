package ru.belov.snakeapplication.view;

import javafx.scene.layout.GridPane;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.UnitPosition;

public abstract class RunFrog {

    private static final int STEP = 1;
    private static final int FIELD_SIZE = 19;
    private static final int FIRST_INDEX = 0;

    public abstract void setPosition(UnitPosition unitPosition, Frog frog);
    public abstract void checkEat(UnitPosition unitPosition, Frog frog, GridPane playingField);

    public void runUp(GridPane playingField, UnitPosition unitPosition, Frog frog) {
        setPosition(unitPosition, frog);
        if (checkOutOfField(frog)) {
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY() - STEP);
            frog.setPositionY(frog.getPositionY() - STEP);
        } else {
            getNewPosition(playingField, frog);
        }
        checkEat(unitPosition, frog, playingField);
    }

    public void runDown(GridPane playingField, UnitPosition unitPosition, Frog frog) {
        setPosition(unitPosition, frog);
        if (checkOutOfField(frog)) {
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY() + STEP);
            frog.setPositionY(frog.getPositionY() + STEP);
        } else {
            getNewPosition(playingField, frog);
        }
        checkEat(unitPosition, frog, playingField);
    }

    public void runLeft(GridPane playingField, UnitPosition unitPosition, Frog frog) {
        setPosition(unitPosition, frog);
        if (checkOutOfField(frog)) {
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX() - STEP, frog.getPositionY());
            frog.setPositionX(frog.getPositionX() - STEP);
        } else {
            getNewPosition(playingField, frog);
        }
        checkEat(unitPosition, frog, playingField);
    }

    public void runRignt(GridPane playingField, UnitPosition unitPosition, Frog frog) {
        setPosition(unitPosition, frog);
        if (checkOutOfField(frog)) {
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX() + STEP, frog.getPositionY());
            frog.setPositionX(frog.getPositionX() + STEP);
        } else {
            getNewPosition(playingField, frog);
        }
        checkEat(unitPosition, frog, playingField);
    }

    public void newFrog(GridPane playingField, Frog frog) {
        playingField.getChildren().remove(frog.getCircle());
        frog.setPositionX((int) (Math.random() * FIELD_SIZE));
        frog.setPositionX((int) (Math.random() * FIELD_SIZE));
    }

    private boolean checkOutOfField(Frog frog) {
        if (frog.getPositionY() <= FIELD_SIZE &&
                frog.getPositionX() <= FIELD_SIZE) return true;
        return false;
    }

    public void getNewPosition(GridPane playingField, Frog frog) {
        if (frog.getPositionX() > FIELD_SIZE) {
            frog.setPositionX(FIRST_INDEX);
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY());
        } else if (frog.getPositionX() < FIRST_INDEX) {
            frog.setPositionX(FIELD_SIZE);
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY());
        } else if (frog.getPositionY() > FIELD_SIZE) {
            frog.setPositionY(FIRST_INDEX);
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY());
        } else if (frog.getPositionY() < FIRST_INDEX) {
            frog.setPositionY(FIELD_SIZE);
            playingField.getChildren().remove(frog.getCircle());
            playingField.add(frog.getCircle(), frog.getPositionX(), frog.getPositionY());
        }
    }

}
