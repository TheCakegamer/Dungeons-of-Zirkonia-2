package app.enemy;

import app.Vector2d;
import app.level.BasicRoom;
import app.objects.DamagableGameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import app.player.MainChar;

import java.util.ArrayList;

public abstract class BasicAI extends DamagableGameEntity {

    private MainChar mainChar;

    public BasicAI(Vector2d speed, double health, Vector2d position, double width, double height, ArrayList<Image> images, GraphicsContext gContext, BasicRoom walls, MainChar mainChar) {
        super(speed,
                health,
                position,
                width,
                height,
                images,
                gContext,
                walls);
        this.mainChar = mainChar;
    }

    private double getMainCharDiffX() {
        return this.getPosition().getX() - mainChar.getPosition().getX();
    }

    private double getMainCharDiffY() {
        return this.getPosition().getX() - mainChar.getPosition().getY();
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
            stop();
            if (getMainCharDiffX() > 0) {
                moveLeft();
                return;
            }
            moveRight();
            return;
        }
        if (isMovedVertically()) {
            stop();
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
