package app.player;

import app.mechanics.Item;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<Item>();

    public void additem(Item newItem) {
        if (inventory.size() < 9) {
            inventory.add(newItem.getSlot(), newItem);
            System.out.println("-------------" + newItem.getSlot());
        }
    }

    public void checkBroken() {
        IntStream.rangeClosed(0, 9).filter(i -> inventory.get(i).outOfDurability()).forEach(i -> inventory.remove(i));
    }

    public int getFreeSlot() {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) == null) {
                return i;
            }
        }
        return inventory.size();
    }

}
