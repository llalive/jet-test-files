/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.llalive.dev.jet.test.functions;

/**
 *
 * @author Павел
 */
public class AckermanFunc extends SimpleFunction {

    private final String TAG = "ACK";

    public String getTag() {
        return TAG;
    }

    @Override
    public String getResult(int[] values) throws IllegalArgumentException {
        if (values.length != 2) {
            throw new IllegalArgumentException("Function needs 2 parameters.");
        }
        
        int m = values[0];
        int n = values[1];
        
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
