package polymorphysm;

import polymorphysm.animals.Animal;
import polymorphysm.animals.Cat;
import polymorphysm.animals.Dog;
import polymorphysm.shapes.Circle;
import polymorphysm.shapes.Rectangle;
import polymorphysm.shapes.Shape;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());

    }
}
