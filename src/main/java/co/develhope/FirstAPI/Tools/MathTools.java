package co.develhope.FirstAPI.Tools;

public class MathTools {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
