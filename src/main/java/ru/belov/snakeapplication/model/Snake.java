package ru.belov.snakeapplication.model;

import javafx.scene.shape.Circle;

import java.util.List;

public class Snake {

    private Circle head;
    private List<Circle> body;

    public Snake(Circle head, List<Circle> body) {
        this.head = head;
        this.body = body;
    }

    public Circle getHead() {
        return head;
    }

    public List<Circle> getBody() {
        return body;
    }

    public void setHead(Circle head) {
        this.head = head;
    }

    public void setBody(List<Circle> body) {
        this.body = body;
    }

}
