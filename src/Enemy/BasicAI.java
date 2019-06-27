package Enemy;

import Level.BasicRoom;
import Objects.DamagableGameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Player.MainChar;

import java.util.ArrayList;

public abstract class BasicAI extends DamagableGameEntity {

    private MainChar mainChar;

    public BasicAI(double speedValue, double health, double posX, double posY, double width, double height, ArrayList<Image> images, GraphicsContext gContext, BasicRoom walls, MainChar mainChar) {
        super(speedValue,
                health,
                posX,
                posY,
                width,
                height,
                images,
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

    private boolean isMovedHorizontally() {
        return Math.abs(getMainCharDiffX()) > Math.abs(getMainCharDiffY());
    }

    private boolean isMovedVertically() {
        return Math.abs(getMainCharDiffX()) < Math.abs(getMainCharDiffY());
    }

    public void moveToMainChar() {
        System.out.println("X: " + getMainCharDiffX());
        System.out.println("Y: " + getMainCharDiffY());
        if (isMovedHorizontally()) {
            stopAll();
            if (getMainCharDiffX() > 0) {
                moveLeft();
                return;
            }
            moveRight();
            return;
        }
        if (isMovedVertically()) {
            stopAll();
            if (getMainCharDiffY() > 0) {
                moveUp();
                return;
            }
            moveDown();
            return;
        }

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
