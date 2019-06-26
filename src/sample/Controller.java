package sample;

import Enemy.Slime;
import Level.BasicRoom;
import Mechanics.Item;
import Mechanics.Weapon;
import Player.MainChar;
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
        slime = new Slime(2, 640, 640, 32, 32, MainCanvas.getGraphicsContext2D(), wallList, mainChar);
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
            //Nach Rechts bewegen
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                mainChar.moveRight();
                System.out.println("RIGHT");
            }
            //Nach Links bewegen
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                mainChar.moveLeft();
                System.out.println("LEFT");
            }
            //nach Oben
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                mainChar.moveUp();
                System.out.println("UP");
            }
            //nach Unten
            if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                mainChar.moveDown();
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
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                mainChar.stopright();
            }
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                mainChar.stopleft();
            }
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                mainChar.stopup();
            }
            if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                mainChar.stopdown();
            }
        });
    }

}