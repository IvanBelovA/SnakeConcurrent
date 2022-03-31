package ru.belov.snakeapplication.model;

public class UnitPosition {

    private int stonesPositionX;
    private int stonesPositionY;
    private volatile int headPositionX;
    private volatile int headPositionY;
    private volatile int redFrogPositionX;
    private volatile int redFrogPositionY;
    private volatile int blueFrogPositionX;
    private volatile int blueFrogPositionY;
    private volatile int frogGreenPositionX;
    private volatile int frogGreenPositionY;
    private volatile boolean stopGame = false;
    private volatile boolean startGame = true;
    private volatile boolean pauseGame = false;

    public int getStonesPositionX() {
        return stonesPositionX;
    }

    public void setStonesPositionX(int stonesPositionX) {
        this.stonesPositionX = stonesPositionX;
    }

    public int getStonesPositionY() {
        return stonesPositionY;
    }

    public void setStonesPositionY(int stonesPositionY) {
        this.stonesPositionY = stonesPositionY;
    }

    public int getRedFrogPositionX() {
        return redFrogPositionX;
    }

    public void setRedFrogPositionX(int redFrogPositionX) {
        this.redFrogPositionX = redFrogPositionX;
    }

    public int getRedFrogPositionY() {
        return redFrogPositionY;
    }

    public void setRedFrogPositionY(int redFrogPositionY) {
        this.redFrogPositionY = redFrogPositionY;
    }

    public int getBlueFrogPositionX() {
        return blueFrogPositionX;
    }

    public void setBlueFrogPositionX(int blueFrogPositionX) {
        this.blueFrogPositionX = blueFrogPositionX;
    }

    public int getBlueFrogPositionY() {
        return blueFrogPositionY;
    }

    public void setBlueFrogPositionY(int blueFrogPositionY) {
        this.blueFrogPositionY = blueFrogPositionY;
    }

    public void setPauseGame(boolean pauseGame) {
        this.pauseGame = pauseGame;
    }

    public boolean isPauseGame() {
        return pauseGame;
    }

    public boolean isStopGame() {
        return stopGame;
    }

    public void setStopGame(boolean stopGame) {
        this.stopGame = stopGame;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public int getHeadPositionX() {
        return headPositionX;
    }

    public void setHeadPositionX(int headPositionX) {
        this.headPositionX = headPositionX;
    }

    public int getHeadPositionY() {
        return headPositionY;
    }

    public void setHeadPositionY(int headPositionY) {
        this.headPositionY = headPositionY;
    }

    public int getFrogGreenPositionX() {
        return frogGreenPositionX;
    }

    public void setFrogGreenPositionX(int frogGreenPositionX) {
        this.frogGreenPositionX = frogGreenPositionX;
    }

    public int getFrogGreenPositionY() {
        return frogGreenPositionY;
    }

    public void setFrogGreenPositionY(int frogGreenPositionY) {
        this.frogGreenPositionY = frogGreenPositionY;
    }
}
