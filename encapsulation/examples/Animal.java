package encapsulation.examples;

public class Animal {
    protected double weight;
    protected double height;
    String name;

    public Animal() {
    }

    public Animal(double weight, double height, String name) {
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    // Example of final method
    public final String makeSound() {
        return "Animal says Hi";
    }

}
