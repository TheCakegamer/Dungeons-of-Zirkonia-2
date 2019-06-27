package Objects;

import Level.BasicRoom;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class DamagableGameEntity extends MovingGameEntity {

    public double health;
    public double totalHealth;

    public DamagableGameEntity(double speedValue, double health, double posX, double posY, double width, double height,
                               ArrayList<Image> images, GraphicsContext gContext, BasicRoom walls) {
        super(speedValue, posX, posY, width, height, images, gContext, walls);
        this.health = health;
        this.totalHealth = health;
    }


    public double getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getPercentage() {
        return health / (totalHealth / 100);
    }

    public void heal(double value) {
        health = health + value;
    }
}
