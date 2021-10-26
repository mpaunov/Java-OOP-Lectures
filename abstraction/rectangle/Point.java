package abstraction.rectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThanOrEqual(Point p) {
        return x >= p.x && y >= p.y;
    }

    public boolean isLessThanOrEqual(Point p) {
        return x <= p.x && y <= p.y;
    }
}
