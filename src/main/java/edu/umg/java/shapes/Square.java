package edu.umg.java.shapes;

public class Square extends Shape {

    private final double side;

    public Square(final double side) {

        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {

        return 4 * side;
    }
    
}
