package Mechanics;

import Objects.BasicGameEntity;
import javafx.scene.image.Image;

public class Item extends BasicGameEntity {

    private Image image;
    private double durability;
    private double durPerUse;
    private int slot;

    Item(Image image, double durability, double durPerUse, int slot) {
        super(-96, slot * 64, 64, 64);
        this.image = image;
        this.durability = durability;
        this.durPerUse = durPerUse;
        this.slot = slot;
    }

    public boolean outOfDurability() {
        return (durability <= 0);
    }
    public void reduceDurability() {
        this.durability -= durPerUse;
    }

}
