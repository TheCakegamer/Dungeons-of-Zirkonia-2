package app.sample;

import app.Vector2d;
import app.enemy.Slime;
import app.level.BasicRoom;
import app.mechanics.Weapon;
import app.player.MainChar;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Controller {
    @FXML
    Canvas MainCanvas;
    private MainChar mainChar;
    private BasicRoom wallList;
    private Slime slime;

    public void initialize() {
        wallList = new BasicRoom(MainCanvas.getGraphicsContext2D());
        mainChar = new MainChar(64, 64, 48, 48, MainCanvas.getGraphicsContext2D(), wallList);
        mainChar.inventory.additem(new Weapon(10, new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm()), 10, 1, 0));
        slime = new Slime(0, new Vector2d(640, 640), 32, 32, MainCanvas.getGraphicsContext2D(), wallList, mainChar);
        gameLoop();
    }


    public void gameLoop() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                addKeyInput(MainCanvas.getScene(), this);
                slime.redraw();
                mainChar.redraw();
                wallList.drawRoom();
            }
        };
        animationTimer.start();
    }

    public void addKeyInput(Scene scene, AnimationTimer animationTimer) {
        scene.setOnKeyPressed((event) -> {
            System.out.println("key pressed");
            //Nach Rechts bewegen
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                if(mainChar.isCollidedRight()) {
                    mainChar.setSpeed(new Vector2d(0, mainChar.getSpeed().getY()));
                } else {
                    mainChar.setSpeed(new Vector2d(5, mainChar.getSpeed().getY()));
                }
                System.out.println("RIGHT");
            }
            //Nach Links bewegen
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                if(mainChar.isCollidedLeft()) {
                    mainChar.setSpeed(new Vector2d(0, mainChar.getSpeed().getY()));
                } else {
                    mainChar.setSpeed(new Vector2d(-5, mainChar.getSpeed().getY()));
                }
                System.out.println("LEFT");
            }
            //nach Oben
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                if(mainChar.isCollidedTop()) {
                    mainChar.setSpeed(new Vector2d(mainChar.getSpeed().getX(), 0));
                } else {
                    mainChar.setSpeed(new Vector2d(mainChar.getSpeed().getX(), -5));
                }
                System.out.println("UP");
            }
            //nach Unten
            if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                if(mainChar.isCollidedBottom()) {
                    mainChar.setSpeed(new Vector2d(mainChar.getSpeed().getX(), 0));
                } else {
                    mainChar.setSpeed(new Vector2d(mainChar.getSpeed().getX(), 5));
                }
                System.out.println("DOWN");
            }


            if (event.getCode() == KeyCode.E) {
                wallList.addWall(3, 3);
                wallList.addWall(4, 3);
                wallList.addWall(5, 3);
                wallList.addWall(2, 3);
                wallList.addWall(3, 4);
                wallList.addWall(3, 5);
                wallList.addWall(3, 7);
                wallList.addWall(3, 8);
                mainChar.inventory.additem(new Weapon(10, new Image(MainChar.class.getResource("/resources/Player.gif").toExternalForm()), 10, 1, mainChar.inventory.getFreeSlot()));
            }
        });


        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                mainChar.setSpeed(new Vector2d(0, mainChar.getSpeed().getY()));
            }
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W || event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                mainChar.setSpeed(new Vector2d(mainChar.getSpeed().getX(), 0));
            }
        });
    }

}