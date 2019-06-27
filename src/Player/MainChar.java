package Player;

import Level.BasicRoom;
import Objects.DamagableGameEntity;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class MainChar extends DamagableGameEntity {


    private static Image walkingup = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm()); //TODO add images
    private static Image walkingdown = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image walkingleft = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image walkingright = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images

    private static Image idleup = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idledown = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idleleft = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images
    private static Image idleright = new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm());//TODO add images

    public static ArrayList<Image> images = new ArrayList<>(Arrays.asList(walkingup, walkingdown, walkingleft, walkingright,
            idleup, idledown, idleleft, idleright));

    public Inventory inventory = new Inventory();

    public MainChar(double posX, double posY, double width, double height, GraphicsContext gContext, BasicRoom walls) {
        super(5, 100.0, posX, posY, width, height, images, gContext, walls);
    }


    public void redraw() {
        super.redraw();
    }

    @Override
    public Rectangle2D getBottom() {
        return new Rectangle2D(getPosX() + 4, getPosY() + getHeight(), getWidth() - 8, 2);
    }

    @Override
    public Rectangle2D getLeft() {
        return new Rectangle2D(getPosX() - 2, getPosY() + 4, 2, getHeight() - 8);
    }

    @Override
    public Rectangle2D getRight() {
        return new Rectangle2D(getPosX() + getWidth(), getPosY() + 4, 2, getHeight() - 8);
    }

    @Override
    public Rectangle2D getTop() {
        return new Rectangle2D(getPosX() + 4, getPosY() - 2, getWidth() - 8, 2);
    }

}
