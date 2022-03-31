package ru.belov.snakeapplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import ru.belov.snakeapplication.controller.FrogController;
import ru.belov.snakeapplication.controller.RunSnakeController;
import ru.belov.snakeapplication.model.Frog;
import ru.belov.snakeapplication.model.Snake;
import ru.belov.snakeapplication.model.UnitPosition;
import ru.belov.snakeapplication.service.CreatorService;
import ru.belov.snakeapplication.view.BlueFrogView;
import ru.belov.snakeapplication.view.GreenFrogView;
import ru.belov.snakeapplication.view.PlayingFieldView;
import ru.belov.snakeapplication.view.RedFrogView;
import ru.belov.snakeapplication.view.RunSnakeView;

import java.util.List;

public class SnakeApplication extends Application {

    private static final int WINDOW_SIZE = 600;
    private static final int SNAKE_DELAY = 400;
    private static final int FROG_DELAY = 1000;
    private static final int BUTTON_HEiGHT = 20;
    private static final int BUTTON_WIDTH = 50;
    private static final int BUTTON_POSITION_X = 20;
    private static final int BUTTON_START_POSITION = 19;
    private static final int BUTTON_STOP_POSITION = 18;
    private static final int BUTTON_PAUSE_POSITION = 17;
    private static final int GREEN_SNAKE = 0;
    private static final int BLUE_SNAKE = 1;
    private static final int RED_SNAKE = 2;

    private UnitPosition unitPosition = new UnitPosition();
    private CreatorService creatorService = new CreatorService();
    private GreenFrogView greenFrogView = new GreenFrogView();
    private BlueFrogView blueFrogView = new BlueFrogView();
    private RedFrogView redFrogView = new RedFrogView();
    private Button startButton;
    private Button stopButton;
    private Thread snakeThread;
    private Thread frogThread;
    private PlayingFieldView playingFieldView;
    private GridPane playingField;
    private Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        createPlayingField();

        scene = new Scene(playingField, WINDOW_SIZE, WINDOW_SIZE);

        createButtonPause();
        startButton = createButtonStart();
        stopButton = createButtonStop();

        createThreadSnake();
        createThreadFrog();

        stage.setTitle("Snake!");
        stage.setScene(scene);
        stage.show();

        snakeThread.start();
        frogThread.start();
    }

    public void createThreadFrog() {
        FrogController frogController = new FrogController(unitPosition);
        List<Frog> frogs = creatorService.createFrogs();

        frogThread = new Thread(()->{
            while (unitPosition.isStartGame()) {
                synchronized (this) {
                    if (unitPosition.isPauseGame()) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Platform.runLater(() ->
                                frogController.runFrog(playingField, greenFrogView, frogs.get(GREEN_SNAKE)));
                        Platform.runLater(() ->
                                frogController.runFrog(playingField, blueFrogView, frogs.get(BLUE_SNAKE)));
                        Platform.runLater(() ->
                                frogController.runFrog(playingField, redFrogView, frogs.get(RED_SNAKE)));
                        try {
                            Thread.sleep(FROG_DELAY);
                        }
                        catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void createThreadSnake() {
        Snake snake = creatorService.createSnake();
        RunSnakeView runSnakeView = new RunSnakeView(snake);
        RunSnakeController runSnakeController = new RunSnakeController(unitPosition);
        creatorService.installSnake(playingField, snake);
        unitPosition.setPauseGame(false);
        swithcButton(startButton, stopButton);

        snakeThread = new Thread(()->{

            while (unitPosition.isStartGame()) {
                    if (unitPosition.isPauseGame()) {
                        synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            }
                        }
                    } else {
                        Platform.runLater(() -> runSnakeController.run(scene, playingField, runSnakeView));
                        try {
                            Thread.sleep(SNAKE_DELAY);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                }
            }
            swithcButton(stopButton, startButton);
        });

        playingField = playingFieldView.createPlayingField(unitPosition);
    }

    private Button createButtonStart() {
        Button button = new Button("Start");
        button.setMinHeight(BUTTON_HEiGHT);
        button.setMinWidth(BUTTON_WIDTH);

        button.setOnAction(actionEvent -> {
            if (unitPosition.isPauseGame()) {
                unitPosition.setPauseGame(false);
                button.setDisable(true);
                toResume();
            } else {
                unitPosition.setStartGame(true);
                unitPosition.setPauseGame(false);

                createThreadSnake();
                createThreadFrog();

                snakeThread.start();
                frogThread.start();

                button.setDisable(true);
            }
        });

        playingField.add(button, BUTTON_POSITION_X, BUTTON_START_POSITION);
        return button;
    }

    private Button createButtonStop() {
        Button button = new Button("Stop");
        button.setMinHeight(BUTTON_HEiGHT);
        button.setMinWidth(BUTTON_WIDTH);

        button.setOnAction(actionEvent -> unitPosition.setStartGame(false));

        playingField.add(button, BUTTON_POSITION_X, BUTTON_STOP_POSITION);
        return button;
    }

    private Button createButtonPause() {
        Button button = new Button("Pause");
        button.setMinHeight(BUTTON_HEiGHT);
        button.setMinWidth(BUTTON_WIDTH);

        button.setOnAction(actionEvent -> {
            unitPosition.setPauseGame(true);
            startButton.setDisable(false);
        });

        playingField.add(button, BUTTON_POSITION_X, BUTTON_PAUSE_POSITION);
        return button;
    }

    public void createPlayingField() {
        playingFieldView = new PlayingFieldView();
        playingField = playingFieldView.createPlayingField(unitPosition);
    }

    public void swithcButton(Button buttonOff, Button buttonOn) {
        buttonOff.setDisable(true);
        buttonOn.setDisable(false);
    }

    public synchronized void toResume() {
        notifyAll();
    }

}
