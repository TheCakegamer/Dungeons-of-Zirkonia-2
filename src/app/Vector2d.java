package app;

public final class Vector2d {
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private final double x;
    private final double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(getX() + other.getX(), getY() + other.getY());
    }
}
