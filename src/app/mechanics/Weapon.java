package app.mechanics;


import javafx.scene.image.Image;

public class Weapon extends app.mechanics.Item {

    private final double damage;

    public Weapon(double damage, Image image, double durability, double durPerHit, int slot) {
        super(image, durability, durPerHit, slot);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }
}
