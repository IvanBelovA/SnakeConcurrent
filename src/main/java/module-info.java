module ru.belov.snakeapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.belov.snakeapplication to javafx.fxml;
    exports ru.belov.snakeapplication;
    exports ru.belov.snakeapplication.model;
    opens ru.belov.snakeapplication.model to javafx.fxml;
}