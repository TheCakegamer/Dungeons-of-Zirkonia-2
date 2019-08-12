package app.objects;

import app.Vector2d;
import app.level.BasicRoom;
import app.mechanics.Weapon;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class DamagableGameEntity extends MovingGameEntity {

    private double health;
    private double totalHealth;

    public DamagableGameEntity(double speedValue, double health, Vector2d position, double width, double height,
                               ArrayList<Image> images, GraphicsContext gContext, BasicRoom walls) {
        super(speedValue, position, width, height, images, gContext, walls);
        this.health = health;
        this.totalHealth = health;
    }

    public abstract Rectangle2D getAttackfieldRight();

    public abstract Rectangle2D getAttackfieldLeft();

    public abstract Rectangle2D getAttackfieldTop();

    public abstract Rectangle2D getAttackfieldBottom();

    public boolean isinAttackfieldRight(DamagableGameEntity object) {
        return object.getAttackfieldRight().intersects(this.getHitbox());
    }

    public boolean isinAttackfieldLeft(DamagableGameEntity object) {
        return object.getAttackfieldLeft().intersects(this.getHitbox());
    }

    public boolean isinAttackfieldTop(DamagableGameEntity object) {
        return object.getAttackfieldTop().intersects(this.getHitbox());
    }

    public boolean isinAttackfieldBottom(DamagableGameEntity object) {
        return object.getAttackfieldBottom().intersects(this.getHitbox());
    }

    public void getDamage(Weapon weapon) {
        weapon.reduceDurability();
        setHealth(getHealth() - weapon.getDamage());
        //TODO Knockback
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getPercentage() {
        return health / (totalHealth / 100);
    }

    public void heal(double value) {
        health = health + value;
    }
}
