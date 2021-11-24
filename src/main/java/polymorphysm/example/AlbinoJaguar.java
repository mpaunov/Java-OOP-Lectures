package polymorphysm.example;

import java.io.IOException;

public class AlbinoJaguar implements Jaguar {
    @Override
    public String runFast() {
        return "I am albino and I am lazy to run cuz I ate";
    }
}
