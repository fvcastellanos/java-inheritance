package edu.umg.java.shapes;

public class Rectangle extends Shape {

    private final double length;
    private final double height;

    public Rectangle(final double length, final double height) {

        this.height = height;
        this.length = length;
    }

    @Override
    public double area() {
        return height * length;
    }

    @Override
    public double perimeter() {
        return 2 * height + 2 * length;
    }
}
