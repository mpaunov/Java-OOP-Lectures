package abstraction.staticdemo;

public class Main {

    static {
        System.out.println("First static block");
    }

    static {
        System.out.println("Second static block");
    }

    public static void main(String[] args) {
        System.out.println("In main");
    }
}
