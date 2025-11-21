package com.example.structural.composite.UIFramework;

public class Button extends Widget {
    @Override
    public void paint() {
        if (isVisible) {
            System.out.println("[Button] Painting ...");
        }
    }

    @Override
    public void setVisibility(boolean isVisible) {
        System.out.println("[Button] visibility : " + isVisible);
        this.isVisible = isVisible;
    }

    @Override
    public void add(Widget widget) {

    }

    @Override
    public void remove(Widget widget) {

    }
}
