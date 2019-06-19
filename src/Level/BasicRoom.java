package Level;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class BasicRoom {

    private ArrayList<Wall> WallList = new ArrayList<>();

    public BasicRoom(GraphicsContext gContext) {
        int index = 0;
        for (int x = 1; x < 15; x++) {
            WallList.add(index, new Wall(gContext, x, 0));
            index++;
        }
        for (int x = 1; x < 15; x++) {
            WallList.add(index, new Wall(gContext, x, 15));
            index++;
        }
        for (int y = 0; y < 16; y++) {
            WallList.add(index, new Wall(gContext, 0, y));
            index++;
            WallList.add(index, new Wall(gContext, 15, y));
            index++;
        }
    }

    public void drawRoom() {
        for (Wall wall : WallList) {
            wall.drawWall();
        }
    }
}
