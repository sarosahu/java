package com.example.structural.composite.UIFramework;

import java.util.ArrayList;
import java.util.List;

public class Frame extends Widget{
    private List<Widget> children = new ArrayList<>();
    private static int depth = 0;
    @Override
    public void paint() {
        if (!isVisible) {
            return;
        }
        System.out.println("[Frame] painting");
        ++depth;
        for (var child : children) {
            for (int i = 0; i < depth; ++i) {
                System.out.print("\t");
            }
            child.paint();
        }
        --depth;
    }

    @Override
    public void setVisibility(boolean isVisible) {
        ++depth;
        this.isVisible = isVisible;
        System.out.println("[Frame] Changing visibility");
        for (var child : children) {
            for (int i = 0; i < depth; ++i) {
                System.out.print("\t");
            }
            child.setVisibility(isVisible);
        }
        --depth;
    }

    @Override
    public void add(Widget widget) {
        children.add(widget);
        widget.setParent(this);
    }

    @Override
    public void remove(Widget widget) {
        widget.setParent(null);
        children.remove(widget);
    }

    @Override
    public Frame getFrame() {
        return this;
    }
}
