package Objects;

public abstract class BasicGameEntity {

    private double posX;
    private double posY;
    private double height;
    private double width;

    public BasicGameEntity(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
