package com.studer.test;

/**
 * Created by Admin on 07.06.2016.
 */
public class Operation {
    int operator1;
    int operator2;
    ArithmeticOperation operation;
    int result;

    public Operation(int operator1, int operator2, ArithmeticOperation operation, int result) {
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.operation = operation;
        this.result = result;
    }

    public static Operation getInstanse(String s){
        String[] params = s.split(";");
        int operator1 = Integer.parseInt(params[0]);
        int operator2 = Integer.parseInt(params[1]);
        ArithmeticOperation operation1 = null;
        try {
            operation1 = ArithmeticOperation.getOperation(params[2]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        int result = Integer.parseInt(params[3]);
        return new Operation(operator1,
                operator2,
                operation1,
                result);
    }

    public boolean checkOperation(){
        int result;
        switch (operation){
            case PLUS:
                result = operator1+operator2;
                break;
            case MINUS:
                result = operator1-operator2;
                break;
            case MULTIPLICATION:
                result = operator1*operator2;
                break;
            case DIVISION:
                result = operator1/operator2;
                break;
            default:
                return false;
        }
        return result==this.result;
    }

    public int getOperator1() {
        return operator1;
    }

    public int getOperator2() {
        return operator2;
    }

    public ArithmeticOperation getOperation() {
        return operation;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return operator1+";"+operator2+";"+operation+";"+result;
    }
}
