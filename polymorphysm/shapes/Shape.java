package polymorphysm.shapes;

public abstract class Shape {
    private Double area;
    private Double perimeter;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();


    protected void setArea(Double area) {
        this.area = area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        if (perimeter == null) {
            calculatePerimeter();
        }
        return perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
        return area;
    }
}
