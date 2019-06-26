package Enemy;

import Level.BasicRoom;
import Objects.MovingGameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Player.MainChar;

public abstract class BasicAI extends MovingGameEntity {

    private MainChar mainChar;

    public BasicAI(double speedValue, double posX, double posY, double width, double height, Image walkingup, Image walkingdown, Image walkingleft, Image walkingright, Image idleup, Image idledown, Image idleleft, Image idleright, GraphicsContext gContext, BasicRoom walls, MainChar mainChar) {
        super(speedValue,
                posX,
                posY,
                width,
                height,
                walkingup,
                walkingdown,
                walkingleft,
                walkingright,
                idleup,
                idledown,
                idleleft,
                idleright,
                gContext,
                walls);
        this.mainChar = mainChar;
    }

    private double getMainCharDiffX() {
        return this.getPosX() - mainChar.getPosX();
    }

    private double getMainCharDiffY() {
        return this.getPosY() - mainChar.getPosY();
    }

    public void moveToMainChar() {
        System.out.println("X: " + getMainCharDiffX());
        System.out.println("Y: " + getMainCharDiffY());
        if (Math.abs(getMainCharDiffX()) > Math.abs(getMainCharDiffY())) {
            if (getMainCharDiffX() > 0) {
                stopAll();
                moveLeft();
            } else if (getMainCharDiffX() < 0) {
                stopAll();
                moveRight();
            }
        } else if (Math.abs(getMainCharDiffX()) < Math.abs(getMainCharDiffY())) {
            if (getMainCharDiffY() > 0) {
                stopAll();
                moveUp();
            } else if (getMainCharDiffY() < 0) {
                stopAll();
                moveDown();
            }
        } else {
            if (getMainCharDiffX() > 0) {
                moveLeft();
            } else if (getMainCharDiffX() < 0) {
                moveRight();
            } else if (getMainCharDiffY() > 0) {
                moveUp();
            } else if (getMainCharDiffY() < 0) {
                moveDown();
            }
        }

    }
}
