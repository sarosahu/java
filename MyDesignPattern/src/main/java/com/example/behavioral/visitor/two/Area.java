package com.example.behavioral.visitor.two;

// Visitor child class for area operation
public class Area implements IOperation{
    private double area;
    @Override
    public void visitCircle(Circle circle) {
        double pi = 3.142;
        this.area = pi * circle.getRadius() * circle.getRadius();
    }

    @Override
    public void visitLine(Line line) {
        System.out.println("Cannot calculate area of a line!");
    }

    public double getArea() {
        return area;
    }
}
