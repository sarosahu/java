package com.example.structural.composite.UIFramework;

public abstract class Widget {
    private Widget parent;
    protected boolean isVisible = true;

    public abstract void paint();
    public abstract void setVisibility(boolean isVisible);
    public abstract void add(Widget widget);
    public abstract void remove(Widget widget);
    public Frame getFrame() {
        return null;
    }
    public void setParent(Widget parent) {
        this.parent = parent;
    }
}
