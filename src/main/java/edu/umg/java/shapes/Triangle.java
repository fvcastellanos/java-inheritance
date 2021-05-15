package edu.umg.java.shapes;

public class Triangle extends Shape {

    private final double base;
    private final double height;
    private final double sideOne;
    private final double sideTwo;
    private final double sideThree;

    public Triangle(final double base,
                    final double height, 
                    final double sideOne,
                    final double sideTwo,
                    final double sideThree) {

        this.base = base;
        this.height = height;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }

    @Override
    public double perimeter() {
        return sideOne + sideTwo + sideThree;
    }
    
}
