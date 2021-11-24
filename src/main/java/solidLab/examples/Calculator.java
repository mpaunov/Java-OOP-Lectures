package solidLab.examples;

public class Calculator {
    protected int result;

    public Calculator() {
        this.result = 0;
    }

    public int add(int left, int right) {
        this.result = left + right;
        return this.result;
    }

    public int subtract(int left, int right) {
        this.result = left - right;
        return this.result;
    }

    public int multiply(int left, int right) {
        this.result = left * right;
        return this.result;
    }
}
