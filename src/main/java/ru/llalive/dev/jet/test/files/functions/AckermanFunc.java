package ru.llalive.dev.jet.test.files.functions;

import java.util.List;

/**
 *
 * @author Павел
 */
public class AckermanFunc extends Function {

    public AckermanFunc() {
        this.tag = "ACK";
        this.paramsNum = 2;
    }

    @Override
    public String getResult(Object[] values) throws IllegalArgumentException {
        checkInput(values);

        int m = (int) values[0];
        int n = (int) values[1];

        return String.valueOf(getAckermanFunc(m, n));
    }

    private int getAckermanFunc(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else {
            if (n > 0) {
                return getAckermanFunc(m - 1, getAckermanFunc(m, n - 1));
            } else {
                return getAckermanFunc(m - 1, 1);
            }
        }
    }

}
