package desingPatterns.command;

import java.util.List;

public class TurnAllLightsOn implements Command {
    private List<Lamp> lamps;

    public TurnAllLightsOn(List<Lamp> lamps) {
        this.lamps = lamps;
    }

    @Override
    public void execute() {
        for (Lamp lamp : lamps) {
            lamp.on();
        }
    }
}
