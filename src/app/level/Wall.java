package app.level;

import app.Vector2d;
import app.objects.BasicGameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Wall extends BasicGameEntity {

    private GraphicsContext gContext;
    private Image wallimg = new Image(getClass().getResource("/resources/dungeonwall.png").toExternalForm());

    public Wall(GraphicsContext gContext, double gridX, double gridY) {
        super(new Vector2d(gridX * 48, gridY * 48), 48, 48);
        this.gContext = gContext;
        setWidth(48);
        setHeight(48);
        setGridX(gridX);
        setGridY(gridY);
        drawWall();
    }

    public void drawWall() {
        gContext.drawImage(wallimg, getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }

    private void resetWall() {
        setGridX(0);
        setGridY(0);
        drawWall();
    }

    private void setGridX(double gridX) {
        setPosition(new Vector2d(gridX * 48, getPosition().getY()));
    }


    private void setGridY(double gridY) {
        setPosition(new Vector2d(getPosition().getX(),gridY * 48));
    }

    public void setWallimg(Image wallimg) {
        this.wallimg = wallimg;
    }
}
