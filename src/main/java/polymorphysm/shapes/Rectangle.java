package polymorphysm.shapes;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(this.width * 2 + this.height * 2);
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.width * this.height);
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }
}
