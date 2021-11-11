package polymorphysm.shapesV2;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return this.width * 2 + this.height * 2;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }
}
