package com.example.structural.adapter.two;

public class AcceleClassAdapter extends Accelerometer implements Input{
    @Override
    public boolean up() {
        return this.getVerticalAxis() > 0;
    }

    @Override
    public boolean down() {
        return this.getVerticalAxis() < 0;
    }

    @Override
    public boolean left() {
        return this.getHorizontalAxis() < 0;
    }

    @Override
    public boolean right() {
        return this.getHorizontalAxis() > 0;
    }
}
