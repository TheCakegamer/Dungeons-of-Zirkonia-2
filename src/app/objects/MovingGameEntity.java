package app.objects;

import app.Vector2d;
import app.level.BasicRoom;
import app.level.Collisions;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class MovingGameEntity extends app.objects.BasicGameEntity {

    private GraphicsContext gContext;

    private Image currentimage;

    private Image walkingup;
    private Image walkingdown;
    private Image walkingleft;
    private Image walkingright;

    private Image idleup;
    private Image idledown;
    private Image idleleft;
    private Image idleright;

    private double health;

    private Vector2d speed;

    private Collisions collisions = new Collisions();

    private BasicRoom walls;

    private String lastdirection = "RIGHT";


    public abstract Rectangle2D getBottom();

    public abstract Rectangle2D getLeft();

    public abstract Rectangle2D getRight();

    public abstract Rectangle2D getTop();

    public MovingGameEntity(Vector2d speed, Vector2d position, double width, double height, ArrayList<Image> images, GraphicsContext gContext, BasicRoom walls) {
        super(position, width, height);
        this.speed = speed;
        this.walkingup = images.get(0);
        this.walkingdown = images.get(1);
        this.walkingleft = images.get(2);
        this.walkingright = images.get(3);
        this.idleup = images.get(4);
        this.idledown = images.get(5);
        this.idleleft = images.get(6);
        this.idleright = images.get(7);
        this.gContext = gContext;
        this.walls = walls;
    }

    public void moveRight() {
            speed = new Vector2d(speed.getLength(), 0);
            lastdirection = "RIGHT";
    }

    public void moveLeft() {
            speed = new Vector2d(-speed.getLength(), 0);
            lastdirection = "LEFT";
    }

    public void moveUp() {
            speed = new Vector2d(0, -speed.getLength());
            lastdirection = "UP";
    }

    public void moveDown() {
            speed = new Vector2d(0, speed.getLength());
            lastdirection = "DOWN";
    }

    public void stop() {
        speed = new Vector2d(0, 0);
    }

    public void redraw() {
        gContext.clearRect(
                getPosition().getX(),
                getPosition().getY(),
                getWidth(),
                getHeight());

        setPosition(getPosition().add(speed));

        changeImage();

        gContext.drawImage(currentimage, getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }

    private void changeImage() {
        if (speed.getX() > 0) {
            currentimage = walkingright;
        } else if (speed.getX() < 0) {
            currentimage = walkingleft;
        } else if (speed.getY() < 0) {
            currentimage = walkingup;
        } else if (speed.getY() > 0) {
            currentimage = walkingdown;
        }
        switch (lastdirection) {
            case "RIGHT":
                currentimage = idleright;
                break;
            case "LEFT":
                currentimage = idleleft;
                break;
            case "UP":
                currentimage = idleup;
                break;
            case "DOWN":
                currentimage = idledown;
                break;
        }
    }


    public Vector2d getSpeed() {
        if (!collisions.checkWallLeft(this, walls) || !collisions.checkWallRight(this, walls)) {
            return new Vector2d(0, speed.getY());
        } else if (!collisions.checkWallUp(this, walls) || !collisions.checkWallDown(this, walls)){
            return new Vector2d(speed.getX(), 0);
        }
        return speed;
    }

    public Rectangle2D getHitbox() {
        return new Rectangle2D(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }
}