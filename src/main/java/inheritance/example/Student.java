package inheritance.example;

public class Student extends Person {
    private String school;

    public Student(String name, int age, String email, String school) {
        super(name, age, email);
        this.school = school;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " And I am studying in " + school;
    }
}
