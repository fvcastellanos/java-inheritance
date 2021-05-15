package edu.umg.java.shapes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Geometry {

    private static final Logger LOGGER = LoggerFactory.getLogger(Geometry.class);
    
    private Shape shape;

    public void calculateAreas() {

        LOGGER.info("Square information");
        shape = new Square(2d);
        shape.displayResult();

        LOGGER.info("Rectangle information");
        shape = new Rectangle(2d, 5d);
        shape.displayResult();

        LOGGER.info("Triangle information");
        shape = new Triangle(2d, 5d, 5d, 5d, 5d);
        shape.displayResult();

    }
}
