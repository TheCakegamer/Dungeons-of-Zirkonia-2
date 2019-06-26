package Mechanics;


import javafx.scene.image.Image;

public class Weapon extends Item {

    public double damage;

    public Weapon(double damage, Image image, double durability, double durPerHit, int slot) {
        super(image, durability, durPerHit, slot);
        this.damage = damage;
    }

    public void dealDamage(Health health) {
        health.recieveDamage(damage);
        durability = -durPerUse;
    }
}
