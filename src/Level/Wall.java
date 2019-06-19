package Level;

import Objects.BasicGameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Wall extends BasicGameEntity {

    private GraphicsContext gContext;
    private Image wallimg = new Image(getClass().getResource("/resources/dungeonwall.png").toExternalForm());

    public Wall(GraphicsContext gContext, double gridX, double gridY) {
        this.gContext = gContext;
        setWidth(48);
        setHeight(48);
        setGridX(gridX);
        setGridY(gridY);
        drawWall();
    }

    public void drawWall() {
        gContext.drawImage(wallimg, getPosX(), getPosY(), getWidth(), getHeight());
    }

    private void resetWall() {
        setGridX(0);
        setGridY(0);
        drawWall();
    }

    private void setGridX(double gridX) {
        setPosX(gridX * 48);
    }


    private void setGridY(double gridY) {
        setPosY(gridY * 48);
    }

    public void setWallimg(Image wallimg) {
        this.wallimg = wallimg;
    }
}
