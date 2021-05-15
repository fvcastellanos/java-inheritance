package edu.umg.java.calculator.operation;

public class AdditionOperation extends TwoOperandOperation {

    public AdditionOperation(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double perfomOperation() {
        return firstOperand + secondOperand;
    }    
}
