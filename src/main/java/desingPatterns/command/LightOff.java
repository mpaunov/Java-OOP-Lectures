package desingPatterns.command;

public class LightOff implements Command {
    private Lamp lamp;

    public LightOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.off();
    }
}
