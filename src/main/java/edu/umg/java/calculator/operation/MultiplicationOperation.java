package edu.umg.java.calculator.operation;

public class MultiplicationOperation extends TwoOperandOperation {

    public MultiplicationOperation(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double perfomOperation() {
        return firstOperand * secondOperand;
    }    
}
