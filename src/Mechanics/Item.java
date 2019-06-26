package Mechanics;

import Objects.BasicGameEntity;
import javafx.scene.image.Image;

public class Item extends BasicGameEntity {

    public Image image;
    public double durability;
    public double durPerUse;
    public int slot;

    public Item(Image image, double durability, double durPerUse, int slot) {
        super(-96, slot * 64, 64, 64);
        this.image = image;
        this.durability = durability;
        this.durPerUse = durPerUse;
        this.slot = slot;
    }

    public boolean outOfDurability() {
        return (durability <= 0);
    }
}
