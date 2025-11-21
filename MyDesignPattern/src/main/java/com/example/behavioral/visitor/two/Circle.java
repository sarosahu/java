package com.example.behavioral.visitor.two;

public class Circle implements IShape {
    private Point pos;
    private int radius;

    public Circle(Point pos, int radius) {
        this.pos = pos;
        this.radius = radius;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void accept(IOperation operation) {
        operation.visitCircle(this);
    }
}
