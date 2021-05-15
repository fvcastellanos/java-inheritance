package edu.umg.java.calculator.operation;

public class SubtractionOperation extends TwoOperandOperation {

    public SubtractionOperation(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double perfomOperation() {
        return firstOperand - secondOperand;
    }
    
}
