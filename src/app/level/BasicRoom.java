package app.level;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class BasicRoom {

    ArrayList<Wall> WallList = new ArrayList<>();
    private GraphicsContext gContext;

    public BasicRoom(GraphicsContext gContext) {
        this.gContext = gContext;
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

    public void addWall(int gridX, int gridY) {
        WallList.add(new Wall(gContext, gridX, gridY));
    }

    public void drawRoom() {
        for (Wall wall : WallList) {
            wall.drawWall();
        }
    }
}
