package Mechanics;


import Objects.DamagableGameEntity;
import javafx.scene.image.Image;

public class Weapon extends Item {

    public double damage;

    public Weapon(double damage, Image image, double durability, double durPerHit, int slot) {
        super(image, durability, durPerHit, slot);
        this.damage = damage;
    }

    public double dealDamage(double health) {
        durability = -durPerUse;
        return health - damage;
    }
}
