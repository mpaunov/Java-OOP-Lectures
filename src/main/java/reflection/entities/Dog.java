package reflection.entities;

public class Dog extends BaseEntity {
    private int numberOfLegs;
    private String color;

    public Dog(int numberOfLegs, String color) {
        this.numberOfLegs = numberOfLegs;
        this.color = color;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
