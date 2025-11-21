package com.example.behavioral.visitor.two;

// Base Visitor interface
public interface IOperation {
    public void visitCircle(Circle circle);
    public void visitLine(Line line);
}
