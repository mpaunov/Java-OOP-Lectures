package solidLab.examples;

public class ProgrammerCalculator extends Calculator {

    public String getAsBinaryString() {
        return Integer.toBinaryString(super.result);
    }
}
