package ru.llalive.dev.jet.test.files.manager;

import ru.llalive.dev.jet.test.files.functions.AckermanFunc;
import ru.llalive.dev.jet.test.files.functions.FactorialFunc;
import ru.llalive.dev.jet.test.files.functions.FibonacciFunc;
import ru.llalive.dev.jet.test.files.interfaces.Function;

/**
 *
 * @author Павел
 */
public class FunctionManager {

    public static Function getFucntionByTag(String TAG) {
        switch (TAG) {
            case "ACK":
                return new AckermanFunc();
            case "F":
                return new FactorialFunc();
            case "FIB":
                return new FibonacciFunc();
            default:
                return null;
        }
    }

}
