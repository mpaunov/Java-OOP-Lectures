package polymorphysm.mathOperation;

public class MathOperation {

    public static int add(int f, int s) {
        return f + s;
    }

    public static int add(int f, int s, int t) {
        int sumFandS = add(f, s);
        return add(sumFandS, t);
    }

    public static int add(int f, int s, int t, int fth) {
        return add(add(f, s, t), fth);
    }
}
