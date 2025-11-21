package com.example.structural.composite.UIFramework;

public class Main {
    public static void main(String[] args) {
        Frame mainWindow = new Frame();
        Button btn = new Button();
        mainWindow.add(btn);
        //mainWindow.paint();

        Frame childWindow = new Frame();
        Button btnFind = new Button();
        childWindow.add(btnFind);
        mainWindow.add(childWindow);
        mainWindow.paint();

        /*System.out.println("Changing visibility");
        mainWindow.setVisibility(false);
        mainWindow.paint();*/
        display(btn);

    }

    public static void display(Widget widget) {
        if (widget.getFrame() != null) {
            widget.add(new Button());
        } else {
            System.out.println("Cannot add widget to leaf node.");
        }
        widget.paint();
    }
}
