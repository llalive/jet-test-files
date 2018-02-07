package ru.llalive.dev.jet.test.files.functions;

/**
 *
 * @author Павел
 */
public abstract class Function {

    String tag;
    int paramsNum;

    public String getTag() {
        return tag;
    }
    
    public int getParamNumber(){
        return paramsNum;
    }

    public abstract String getResult(Object[] values);

    public void checkInput(Object[] values) throws IllegalArgumentException {
        if (values.length != paramsNum) {
            throw new IllegalArgumentException("Function " + tag + " needs " + paramsNum + " params");
        }
    }
}
