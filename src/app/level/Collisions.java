package app.level;

import app.objects.MovingGameEntity;

public class Collisions {

    public boolean checkWallRight(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getRight().intersects(walls.WallList.get(i).getPosition().getX(), walls.WallList.get(i).getPosition().getY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }

        }
        return true;
    }

    public boolean checkWallLeft(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getLeft().intersects(walls.WallList.get(i).getPosition().getX(), walls.WallList.get(i).getPosition().getY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWallUp(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getTop().intersects(walls.WallList.get(i).getPosition().getX(), walls.WallList.get(i).getPosition().getY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWallDown(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getBottom().intersects(walls.WallList.get(i).getPosition().getX(), walls.WallList.get(i).getPosition().getY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkHitbox(MovingGameEntity object1, MovingGameEntity object2) {
        return object1.getHitbox().intersects(object2.getHitbox());
    }
}
