package app.enemy;

import app.Vector2d;
import app.level.BasicRoom;
import app.player.MainChar;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Slime extends BasicAI {

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

    public Slime(double speedValue, Vector2d position, double width, double height, GraphicsContext gContext, BasicRoom walls, MainChar mainChar) {
        super(speedValue,
                50,
                position,
                width,
                height,
                images,
                gContext,
                walls,
                mainChar);
    }

    @Override
    public void redraw() {
        moveToMainChar();
        super.redraw();
    }

    @Override
    public Rectangle2D getBottom() {
        return new Rectangle2D(getPosition().getX() + 2, getPosition().getY() + getHeight(), getWidth() - 4, 2);
    }

    @Override
    public Rectangle2D getLeft() {
        return new Rectangle2D(getPosition().getX() - 2, getPosition().getY() + 2, 2, getHeight() - 4);
    }

    @Override
    public Rectangle2D getRight() {
        return new Rectangle2D(getPosition().getX() + getWidth(), getPosition().getY() + 2, 2, getHeight() - 4);
    }

    @Override
    public Rectangle2D getTop() {
        return new Rectangle2D(getPosition().getX() + 2, getPosition().getY() - 2, getWidth() - 4, 2);
    }

    @Override
    public Rectangle2D getAttackfieldRight() {
        return null;
    }

    @Override
    public Rectangle2D getAttackfieldLeft() {
        return null;
    }

    @Override
    public Rectangle2D getAttackfieldTop() {
        return null;
    }

    @Override
    public Rectangle2D getAttackfieldBottom() {
        return null;
    }
}
