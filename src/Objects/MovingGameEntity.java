package Objects;

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

    private double posX = 0;
    private double posY = 0;

    private boolean moving;

    private String lastdirection = "RIGHT";

    public abstract Rectangle2D getBottom();

    public abstract Rectangle2D getLeft();

    public abstract Rectangle2D getRight();

    public abstract Rectangle2D getTop();

    public MovingGameEntity(Image walkingup, Image walkingdown, Image walkingleft, Image walkingright, Image idleup, Image idledown, Image idleleft, Image idleright, GraphicsContext gContext) {
        this.walkingup = walkingup;
        this.walkingdown = walkingdown;
        this.walkingleft = walkingleft;
        this.walkingright = walkingright;
        this.idleup = idleup;
        this.idledown = idledown;
        this.idleleft = idleleft;
        this.idleright = idleright;
        this.gContext = gContext;
    }

    public void moveRight() {
        rightspeed = 2;
        lastdirection = "RIGHT";
        moving = true;
    }

    public void moveLeft() {
        leftspeed = -2;
        lastdirection = "LEFT";
        moving = true;
    }

    public void moveUp() {
        upspeed = 2;
        lastdirection = "UP";
        moving = true;
    }

    public void moveDown() {
        downspeed = -2;
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

    public void redraw() {
        gContext.clearRect(
                gContext.getCanvas().getLayoutX(),
                gContext.getCanvas().getLayoutY(),
                gContext.getCanvas().getWidth(),
                gContext.getCanvas().getHeight());

        setPosX(getPosX() + rightspeed + leftspeed);
        setPosY(getPosY() + upspeed + downspeed);

        changeImage();

        gContext.drawImage(currentimage, posX, posY, getWidth(), getHeight());
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
}
