package ru.belov.snakeapplication.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ru.belov.snakeapplication.model.Snake;
import ru.belov.snakeapplication.model.UnitPosition;

public class RunSnakeView {

    private static final int MIN_SIZE_SNAKE = 4;
    private static final int FIRST_INDEX = 0;
    private static final int FIELD_SIZE = 19;
    private static final int BODY_RADIUS = 20 / 3;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 20;
    private static final int SCORE_POSITION_X = 20;
    private static final int SCORE_POSITION_Y = 16;
    private static final String SCORE_LABEL = "Score: ";


    private Snake snake;
    private int positionX = 2;
    private int positionY = 0;
    private Integer score = 0;

    public RunSnakeView(Snake snake) {
        this.snake = snake;
    }

    public void runUp(GridPane playingField, UnitPosition unitPosition) {
        setPosition(unitPosition);

        if(checkEatFrog(unitPosition)) {
            eat(playingField);
            drawScore(playingField);
        } else if (checkEatRedFrog(unitPosition)) {
            eatRedFrog(playingField, unitPosition);
            drawScore(playingField);
            drawScore(playingField);
        } else if (checkGameOver(unitPosition)) {
            unitPosition.setStartGame(false);
        } else {
            runBody(playingField);
        }

        playingField.getChildren().remove(snake.getHead());
        playingField.add(snake.getHead(), positionX, --positionY);
        checkPlayingField(playingField);
    }

    public void runDown(GridPane playingField, UnitPosition unitPosition) {
        setPosition(unitPosition);

        if(checkEatFrog(unitPosition)) {
            eat(playingField);
            drawScore(playingField);
        } else if (checkEatRedFrog(unitPosition)) {
            eatRedFrog(playingField, unitPosition);
            drawScore(playingField);
            drawScore(playingField);
        } else if (checkGameOver(unitPosition)) {
            unitPosition.setStartGame(false);
        } else {
            runBody(playingField);
        }

        playingField.getChildren().remove(snake.getHead());
        playingField.add(snake.getHead(), positionX, ++positionY);
        checkPlayingField(playingField);
    }

    public void runLeft(GridPane playingField, UnitPosition unitPosition) {
        setPosition(unitPosition);

        if(checkEatFrog(unitPosition)) {
            eat(playingField);
            drawScore(playingField);
        } else if (checkEatRedFrog(unitPosition)) {
            eatRedFrog(playingField, unitPosition);
            drawScore(playingField);
            drawScore(playingField);
        } else if (checkGameOver(unitPosition)) {
            unitPosition.setStartGame(false);
        } else {
            runBody(playingField);
        }

        playingField.getChildren().remove(snake.getHead());
        playingField.add(snake.getHead(), --positionX, positionY);
        checkPlayingField(playingField);
    }

    public void runRignt(GridPane playingField, UnitPosition unitPosition) {
        setPosition(unitPosition);

        if(checkEatFrog(unitPosition)) {
            eat(playingField);
            drawScore(playingField);
        } else if (checkEatRedFrog(unitPosition)) {
            eatRedFrog(playingField, unitPosition);
            drawScore(playingField);
            drawScore(playingField);
        } else if (checkGameOver(unitPosition)) {
            unitPosition.setStartGame(false);
        } else {
            runBody(playingField);
        }

        playingField.getChildren().remove(snake.getHead());
        playingField.add(snake.getHead(), ++positionX, positionY);
        checkPlayingField(playingField);
    }

    private void runBody(GridPane playingField) {
        playingField.getChildren().remove(snake.getBody().get(0));
        playingField.add(snake.getBody().get(FIRST_INDEX), positionX, positionY);
        snake.getBody().add(snake.getBody().get(FIRST_INDEX));
        snake.getBody().remove(FIRST_INDEX);
    }

    private void eat(GridPane playingField) {
        Circle circle = new Circle();
        circle.setRadius(BODY_RADIUS);
        circle.setFill(Color.YELLOW);
        snake.getBody().add(circle);
        playingField.add(snake.getBody().get(snake.getBody().size() - 1), positionX, positionY);
    }

    private void eatRedFrog(GridPane playingField, UnitPosition unitPosition) {
        if (snake.getBody().size() <= MIN_SIZE_SNAKE) {
            unitPosition.setStartGame(false);
        } else if (snake.getBody().size() > MIN_SIZE_SNAKE) {
            playingField.getChildren().remove(snake.getBody().get(FIRST_INDEX));
            snake.getBody().remove(FIRST_INDEX);
            playingField.getChildren().remove(snake.getBody().get(1));
            snake.getBody().remove(1);
        }
    }

    private void drawScore(GridPane playingField) {
        score++;
        Label count = new Label(SCORE_LABEL + score);

        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setFill(Color.WHITE);

        playingField.getChildren().remove(rectangle);
        playingField.add(rectangle, SCORE_POSITION_X, SCORE_POSITION_Y);

        playingField.getChildren().remove(count);
        playingField.add(count, SCORE_POSITION_X, SCORE_POSITION_Y);

    }

    private void setPosition(UnitPosition unitPosition) {
        unitPosition.setHeadPositionX(positionX);
        unitPosition.setHeadPositionY(positionY);
    }

    public void checkPlayingField(GridPane playingField) {
        if (positionX > FIELD_SIZE) {
            positionX = FIRST_INDEX;
            playingField.getChildren().remove(snake.getHead());
            playingField.add(snake.getHead(), positionX, positionY);
        } else if (positionX < FIRST_INDEX) {
            positionX = FIELD_SIZE;
            playingField.getChildren().remove(snake.getHead());
            playingField.add(snake.getHead(), positionX, positionY);
        } else if (positionY > FIELD_SIZE) {
            positionY = FIRST_INDEX;
            playingField.getChildren().remove(snake.getHead());
            playingField.add(snake.getHead(), positionX, positionY);
        } else if (positionY < FIRST_INDEX) {
            positionY = FIELD_SIZE;
            playingField.getChildren().remove(snake.getHead());
            playingField.add(snake.getHead(), positionX, positionY);
        }
    }

    private boolean checkEatFrog(UnitPosition unitPosition) {
        if(unitPosition.getFrogGreenPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getFrogGreenPositionY() == unitPosition.getHeadPositionY()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkEatRedFrog(UnitPosition unitPosition) {
        if (unitPosition.getRedFrogPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getRedFrogPositionY() == unitPosition.getHeadPositionY()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkGameOver(UnitPosition unitPosition) {
        if (unitPosition.getBlueFrogPositionX() == unitPosition.getHeadPositionX() &&
                unitPosition.getBlueFrogPositionY() == unitPosition.getHeadPositionY()||
                unitPosition.getStonesPositionX() == unitPosition.getHeadPositionX() &&
                        unitPosition.getStonesPositionY() == unitPosition.getHeadPositionY()) {
            return true;
        } else {
            return false;
        }
    }

    private void checkSnakeLength(UnitPosition unitPosition) {
        if (snake.getBody().size() < MIN_SIZE_SNAKE) {
            unitPosition.setStartGame(false);
        }
    }

}
