package ru.llalive.dev.jet.test.files.functions;

/**
 *
 * @author babikov_pv
 */
public class FibonacciFunc extends Function {

    public FibonacciFunc() {
        this.tag = "FIB";
        this.paramsNum = 1;
    }

    @Override
    public String getResult(Object[] values) throws IllegalArgumentException {
        checkInput(values);
        int num = (int) values[0];
        return String.valueOf(fibonachi(num));
    }

    private int fibonachi(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

}
