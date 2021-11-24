package encapsulation.examples;

import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    List<Animal> animals;

    public Shelter(List<Animal> animals) {
        this.animals = animals;
    }

    /// This is a package private demo
    public String getAnimals() {
        return this.animals.stream()
                .map(a -> a.name)
                .collect(Collectors.joining("|"));
    }
}
