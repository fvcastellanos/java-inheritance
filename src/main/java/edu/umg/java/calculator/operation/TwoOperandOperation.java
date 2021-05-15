package edu.umg.java.calculator.operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TwoOperandOperation {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final double firstOperand;
    protected final double secondOperand;

    public TwoOperandOperation(final double firstOperand, final double secondOperand) {

        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public abstract double perfomOperation();

    public void displayResult() {

        logger.info("Operation result: {}", perfomOperation());
    }
}
