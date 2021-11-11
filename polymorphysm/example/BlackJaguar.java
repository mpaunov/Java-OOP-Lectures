package polymorphysm.example;

public class BlackJaguar implements Jaguar {
    @Override
    public String runFast() {
        return "I am black Jaguar and I can run fast too";
    }

    public String hideInTheDark() {
        return "Okay, I am hidden";
    }
}
