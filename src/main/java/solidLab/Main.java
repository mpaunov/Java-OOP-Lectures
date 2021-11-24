package solidLab;

import solidLab.examples.ProgrammerCalculator;

public class Main {
    public static void main(String[] args) {
        ProgrammerCalculator calculator = new ProgrammerCalculator();

        int result = calculator.add(13, 73);

        System.out.println(result);

        System.out.println(calculator.getAsBinaryString());
    }
}
