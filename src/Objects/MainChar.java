package Objects;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MainChar extends MovingGameEntity {

    private double posX;
    private double posY;
    private double width;
    private double height;

    private static Image walkingup = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm()); //TODO add images
    private static Image walkingdown = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image walkingleft = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image walkingright = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images

    private static Image idleup = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idledown = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idleleft = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idleright = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images


    public MainChar(double posX, double posY, double width, double height, GraphicsContext gContext) {
        super(5, walkingup, walkingdown, walkingleft, walkingright, idleup, idledown, idleleft, idleright, gContext);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }


    public void redraw() {
        super.redraw();
    }

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public Rectangle2D getBottom() {
        return new Rectangle2D(posX + 8, posY + height, width - 16, 1);
    }

    @Override
    public Rectangle2D getLeft() {
        return new Rectangle2D(posX + 8, posY, 1, height);
    }

    @Override
    public Rectangle2D getRight() {
        return new Rectangle2D(posX + width - 8, posY, 1, height);
    }

    @Override
    public Rectangle2D getTop() {
        return new Rectangle2D(posX + 8, posY, width - 16, 1);
    }

}
