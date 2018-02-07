package ru.llalive.dev.jet.test.files.functions;

/**
 *
 * @author babikov_pv
 */
public class FactorialFunc extends Function {

    public FactorialFunc() {
        this.tag = "F";
        this.paramsNum = 1;
    }

    @Override
    public String getResult(Object[] values) throws IllegalArgumentException {
        checkInput(values);
        int num = (int) values[0];
        return String.valueOf(factorial(num));
    }

    private int factorial(int num) {
        return (num == 0) ? 1 : num * factorial(num - 1);
    }
}
