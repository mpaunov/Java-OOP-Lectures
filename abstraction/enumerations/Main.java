package abstraction.enumerations;

public class Main {
    public static void main(String[] args) {
        DayOfWeek[] values = DayOfWeek.values();

        for (DayOfWeek value : values) {
            System.out.println(value.getName());
        }
    }
}
