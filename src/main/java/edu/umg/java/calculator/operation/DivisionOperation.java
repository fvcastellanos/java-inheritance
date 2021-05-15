package edu.umg.java.calculator.operation;

public class DivisionOperation extends TwoOperandOperation {

    public DivisionOperation(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double perfomOperation() {
        return firstOperand / secondOperand;
    }
    
}
