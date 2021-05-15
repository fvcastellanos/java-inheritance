package edu.umg.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.umg.java.calculator.Calculator;
import edu.umg.java.calculator.operation.OperationType;

@SpringBootApplication
public class JavaInheritanceApplication implements CommandLineRunner {

	private final static Logger LOGGER = LoggerFactory.getLogger(JavaInheritanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaInheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) {

		LOGGER.info("Calculator");

		if (args.length < 2) {

			LOGGER.error("Not enough parameters");
		}

		double fistNumber = Double.parseDouble(args[0]);
		double secondNumber = Double.parseDouble(args[1]);

		var calculator = new Calculator(fistNumber, secondNumber);

		calculator.performOperation(OperationType.ADDITION);
		calculator.performOperation(OperationType.SUBTRACTION);
		calculator.performOperation(OperationType.MULTIPLICATION);
		calculator.performOperation(OperationType.DIVISION);


	}
}
