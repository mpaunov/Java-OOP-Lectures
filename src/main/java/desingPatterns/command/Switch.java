package desingPatterns.command;

import java.util.ArrayDeque;

public class Switch {

    private ArrayDeque<Command> history;

    public Switch() {
        this.history = new ArrayDeque<>();
    }

    public void storeAndExecute(Command command) {
        this.history.push(command);
        command.execute();
    }

    public void undoExecuted() {
        this.history.pop();
        Command command = this.history.peek();
        if (command != null) {
            command.execute();
        }
    }
}
