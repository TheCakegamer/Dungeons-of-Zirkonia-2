package app.objects;

import app.Vector2d;

public abstract class BasicGameEntity {

    private Vector2d position;
    private double height;
    private double width;

    public BasicGameEntity(Vector2d position, double width, double height) {
        this.position = position;
        this.height = height;
        this.width = width;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
