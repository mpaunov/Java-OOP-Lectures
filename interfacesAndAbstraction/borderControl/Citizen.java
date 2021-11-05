package interfacesAndAbstraction.borderControl;

public class Citizen implements Identifiable {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
