package inheritance;

import inheritance.example.Employee;
import inheritance.example.Person;
import inheritance.example.Student;
import inheritance.randomArrayList.RandomArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Pesho", 13, "pesho@email.com");
        Person person2 = new Employee("Emp", 13, "emp@email.com", "SoftUni");
        Person person3 = new Student("Study", 13, "study@email.com", "SoftUni");

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);

        for (Person person : people) {
            System.out.println(person.getInfo());
        }

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        for (int i = 1; i <= 13; i++) {
            randomArrayList.add(i);
        }

        System.out.println(randomArrayList.size());

        System.out.println(randomArrayList.getRandomElement());

        StackOfStrings stack = new StackOfStrings();

        stack.isEmpty();

    }
}
