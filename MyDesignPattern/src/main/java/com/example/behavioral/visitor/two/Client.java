package com.example.behavioral.visitor.two;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<IShape> shapes = new ArrayList<>();
        shapes.add(new Circle(new Point(1, 2), 10));
        shapes.add(new Line(new Point(10, 20), new Point(-10, -20)));

        // {Render operation
        for (IShape shape : shapes) {
            shape.accept(new Renderer());
        }
        // }

        // At this point there was only one operation was defined.

        // Let's say we want to add a new operation called Area() i.e.
        // we want to perform area operation aginst all shapes.
        // So we can have a new visitor called Area and define its visitCircle() and visitLine() methods.
        // Now we have added new visitor class "Area" and added the definition to its methods.
        // That is it. We just need to visit to each shape structures.

        // { Area operation
        Area areaOperation = new Area();
        for (IShape shape : shapes) {
            shape.accept(areaOperation);
        }
        System.out.println("Area of circle is : " + areaOperation.getArea());
        // }

    }
}
