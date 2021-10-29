package encapsulation.tasks.three_validation;

import encapsulation.tasks.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            try {
                Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        DecimalFormat formatter = new DecimalFormat("#.0####");

        double bonus = Double.parseDouble(reader.readLine());

        for (Person person : people) {

            person.increaseSalary(bonus);

            System.out.printf("%s %s gets %s leva%n", person.getFirstName(),
                    person.getLastName(), formatter.format(person.getSalary()));
        }
    }
}
