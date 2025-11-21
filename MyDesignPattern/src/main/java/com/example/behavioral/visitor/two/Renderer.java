package com.example.behavioral.visitor.two;

// Visitor child class Renderer (One type of operation)
public class Renderer implements IOperation {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Circle with radius " + circle.getRadius() + " is rendered.");
    }

    @Override
    public void visitLine(Line line) {
        System.out.println("Line " + line + " is rendered.");
    }
}
