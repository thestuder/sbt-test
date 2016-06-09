package com.studer.test;

/**
 * Created by Admin on 07.06.2016.
 */
public enum ArithmeticOperation {
    PLUS,
    MINUS,
    DIVISION,
    MULTIPLICATION;

    public static ArithmeticOperation getOperation(String s) throws Exception {
        if("+".equals(s)) return PLUS;
        if("-".equals(s)) return MINUS;
        if("*".equals(s)) return MULTIPLICATION;
        if("/".equals(s)) return DIVISION;
        throw new Exception("no operation");
    }
}
