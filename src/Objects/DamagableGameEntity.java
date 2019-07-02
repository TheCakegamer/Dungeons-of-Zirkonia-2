package Objects;

import Level.BasicRoom;
import Mechanics.Weapon;
import javafx.geometry.Rectangle2D;
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
        weapon.dealDamage(health);
        //TODO Knockback
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
