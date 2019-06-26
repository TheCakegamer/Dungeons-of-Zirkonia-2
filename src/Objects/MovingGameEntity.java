package Objects;

import Level.BasicRoom;
import Level.Collisions;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class MovingGameEntity extends BasicGameEntity {

    private GraphicsContext gContext;

    private double leftspeed;
    private double rightspeed;
    private double upspeed;
    private double downspeed;

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

    private double speedValue;

    private boolean moving;

    private Collisions collisions = new Collisions();

    private BasicRoom walls;

    private String lastdirection = "RIGHT";


    public abstract Rectangle2D getBottom();

    public abstract Rectangle2D getLeft();

    public abstract Rectangle2D getRight();

    public abstract Rectangle2D getTop();

    public MovingGameEntity(double speedValue, double posX, double posY, double width, double height, Image walkingup, Image walkingdown, Image walkingleft, Image walkingright, Image idleup, Image idledown, Image idleleft, Image idleright, GraphicsContext gContext, BasicRoom walls) {
        super(posX, posY, width, height);
        this.speedValue = speedValue;
        this.walkingup = walkingup;
        this.walkingdown = walkingdown;
        this.walkingleft = walkingleft;
        this.walkingright = walkingright;
        this.idleup = idleup;
        this.idledown = idledown;
        this.idleleft = idleleft;
        this.idleright = idleright;
        this.gContext = gContext;
        this.walls = walls;
    }

    public void moveRight() {
            rightspeed = speedValue;
            lastdirection = "RIGHT";
            moving = true;
    }

    public void moveLeft() {
            leftspeed = -speedValue;
            lastdirection = "LEFT";
            moving = true;
    }

    public void moveUp() {
            upspeed = -speedValue;
            lastdirection = "UP";
            moving = true;
    }

    public void moveDown() {
            downspeed = speedValue;
            lastdirection = "DOWN";
            moving = true;
    }

    public void stopleft() {
        leftspeed = 0;
        moving = false;
    }

    public void stopright() {
        rightspeed = 0;
        moving = false;
    }

    public void stopup() {
        upspeed = 0;
        moving = false;
    }

    public void stopdown() {
        downspeed = 0;
        moving = false;
    }

    public void stopAll() {
        stopright();
        stopleft();
        stopup();
        stopdown();
    }

    public void redraw() {
        gContext.clearRect(
                getPosX(),
                getPosY(),
                getWidth(),
                getHeight());

        setPosX(getPosX() + getRightspeed() + getLeftspeed());
        setPosY(getPosY() + getUpspeed() + getDownspeed());

        changeImage();

        gContext.drawImage(currentimage, getPosX(), getPosY(), getWidth(), getHeight());
    }

    private void changeImage() {
        if (rightspeed != 0) {
            currentimage = walkingright;
        } else if (leftspeed != 0) {
            currentimage = walkingleft;
        } else if (upspeed != 0) {
            currentimage = walkingup;
        } else if (downspeed != 0) {
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

    public double getLeftspeed() {
        if (!collisions.checkWallLeft(this, walls)) {
            return 0;
        }
        return leftspeed;
    }

    public void setLeftspeed(double leftspeed) {
        this.leftspeed = leftspeed;
    }

    public double getRightspeed() {
        if (!collisions.checkWallRight(this, walls)) {
            return 0;
        }
        return rightspeed;
    }

    public void setRightspeed(double rightspeed) {
        this.rightspeed = rightspeed;
    }

    public double getUpspeed() {
        if (!collisions.checkWallUp(this, walls)) {
            return 0;
        }
        return upspeed;
    }

    public void setUpspeed(double upspeed) {
        this.upspeed = upspeed;
    }

    public double getDownspeed() {
        if (!collisions.checkWallDown(this, walls)) {
            return 0;
        }
        return downspeed;
    }

    public void setDownspeed(double downspeed) {
        this.downspeed = downspeed;
    }

    public Rectangle2D getHitbox() {
        return new Rectangle2D(getPosX(), getPosY(), getWidth(), getHeight());
    }
}