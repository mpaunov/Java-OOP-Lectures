package encapsulation;

import encapsulation.tasks.Person;

public class Main {
    public static void main(String[] args) {
        // Mutable vs Immutable

        String text = "The quick brow fox jumps over the lazy dog";

        String substring = text.substring(0, 10);
        String concat = text.concat(" some postfix");

        Person p = new Person("Mariika", "Ivanova", 32, 1000);

        System.out.println(p.toString());
        p.setLastName("Hristova");
        System.out.println(p.toString());

        System.out.println(text);
        System.out.println(substring);
        System.out.println(concat);
    }
}
