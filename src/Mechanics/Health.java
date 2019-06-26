package Mechanics;

public class Health {

    public double health;
    public double totalHealth;

    public Health(double health) {
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

    public void recieveDamage(double damage) {
        health = health - damage;
    }

    public void heal(double value) {
        health = health + value;
    }
}
