package ru.belov.snakeapplication.service;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.Snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatorService {

    private static final int SNAKE_HEAD_RADIUS = 20 / 2;
    private static final int SNAKE_BODY_RADIUS = 20 / 3;
    private static final int SNAKE_TAIL_RADIUS = 20 / 3;

    public Snake createSnake() {
        Circle head = new Circle();
        head.setRadius(SNAKE_HEAD_RADIUS);
        head.setFill(Color.YELLOW);

        Circle bodyCircle = new Circle();
        bodyCircle.setRadius(SNAKE_BODY_RADIUS);
        bodyCircle.setFill(Color.YELLOW);

        Circle tail = new Circle();
        tail.setRadius(SNAKE_TAIL_RADIUS);
        tail.setFill(Color.YELLOW);

        List<Circle> body = new ArrayList<>();
        body.add(bodyCircle);
        body.add(tail);

        return new Snake(head, body);
    }

    public List<Frog> createFrogs() {
        return Arrays.asList(new Frog(new Circle(), 5, 5, Color.GREEN),
                new Frog(new Circle(), 10, 10, Color.BLUE),
                new Frog(new Circle(), 15, 15, Color.RED));
    }

    public void installSnake(GridPane playingField, Snake snake) {
        playingField.add(snake.getBody().get(0), 0, 0);
        playingField.add(snake.getBody().get(1), 1, 0);
    }

}
