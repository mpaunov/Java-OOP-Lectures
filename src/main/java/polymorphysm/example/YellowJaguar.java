package polymorphysm.example;

public class YellowJaguar implements Jaguar {
    @Override
    public String runFast() {
        return "I am yellow (kindaaa) and I can run fast";
    }

    public String eatPrey(){
        return "Eating, what i caught";
    }
}
