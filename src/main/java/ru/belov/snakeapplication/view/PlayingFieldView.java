package ru.belov.snakeapplication.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ru.belov.snakeapplication.model.UnitPosition;

import java.io.File;

public class PlayingFieldView {

    private static final int FIELD_SIZE = 19;
    private static final int BODY_RADIUS = 20 / 2;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 20;
    private static final int SCORE_POSITION_X = 20;
    private static final int SCORE_POSITION_Y = 16;

    private GridPane playingField = new GridPane();

    public GridPane createPlayingField(UnitPosition unitPosition) {
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {

                File file = new File("src/main/resources/paint.png");
                Image image = new Image(file.toURI().toString());
                ImageView view = new ImageView(image);
                view.setImage(image);

                StackPane bar = new StackPane(view);

                playingField.add(bar, i, j);

                view.fitWidthProperty().bind(bar.widthProperty().subtract(2));
                view.fitHeightProperty().bind(bar.heightProperty().subtract(2));

                bar.prefWidthProperty().bind(playingField.widthProperty().divide(20));
                bar.prefHeightProperty().bind(playingField.heightProperty().divide(20));
            }
        }
        drawScore(playingField);

        installStones(playingField, unitPosition);
        return playingField;
    }

    private void drawScore(GridPane playingField) {
        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setFill(Color.WHITE);

        playingField.getChildren().remove(rectangle);
        playingField.add(rectangle, SCORE_POSITION_X, SCORE_POSITION_Y);
    }

    public void installStones(GridPane playingField, UnitPosition unitPosition) {
        Circle circle = new Circle();
        circle.setRadius(BODY_RADIUS);
        circle.setFill(Color.GRAY);
        int positionX = (int) (Math.random() * FIELD_SIZE);
        int positionY = (int) (Math.random() * FIELD_SIZE);
        unitPosition.setStonesPositionX(positionX);
        unitPosition.setStonesPositionY(positionY);
        playingField.add(circle, positionX, positionY);
    }

}
