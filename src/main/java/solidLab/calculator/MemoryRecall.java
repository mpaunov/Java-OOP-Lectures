package solidLab.calculator;

import java.util.Stack;

public class MemoryRecall implements Operation {
    private Stack<Integer> memory;

    public MemoryRecall(Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return !this.memory.isEmpty();
    }
}
