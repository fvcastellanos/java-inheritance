package edu.umg.java.shapes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Shape {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract double area();
    public abstract double perimeter();

    public void displayResult() {

        logger.info("shape area: {} - perimeter: {}", area(), perimeter());
    }
}
