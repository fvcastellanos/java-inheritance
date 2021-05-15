package edu.umg.java.calculator;

import java.util.HashMap;
import java.util.Map;

import edu.umg.java.calculator.operation.AdditionOperation;
import edu.umg.java.calculator.operation.DivisionOperation;
import edu.umg.java.calculator.operation.MultiplicationOperation;
import edu.umg.java.calculator.operation.OperationType;
import edu.umg.java.calculator.operation.SubtractionOperation;
import edu.umg.java.calculator.operation.TwoOperandOperation;

public class Calculator {

    private final Map<OperationType, TwoOperandOperation> operationMap;

    private final double firstOperand;
    private final double secondOperand;

    public Calculator(final double firstOperand, final double secondOperand) {        

        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operationMap = buildOperationMap();
    }

    public void performOperation(final OperationType operationType) {

        operationMap.get(operationType).displayResult();
    }

    private Map<OperationType, TwoOperandOperation> buildOperationMap() {

        var operationMap = new HashMap<OperationType, TwoOperandOperation>();

        operationMap.put(OperationType.ADDITION, new AdditionOperation(firstOperand, secondOperand));
        operationMap.put(OperationType.SUBTRACTION, new SubtractionOperation(firstOperand, secondOperand));
        operationMap.put(OperationType.MULTIPLICATION, new MultiplicationOperation(firstOperand, secondOperand));
        operationMap.put(OperationType.DIVISION, new DivisionOperation(firstOperand, secondOperand));

        return operationMap;
    }
}
