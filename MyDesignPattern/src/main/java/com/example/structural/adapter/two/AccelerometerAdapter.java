package com.example.structural.adapter.two;

public class AccelerometerAdapter implements Input {
    private Accelerometer accelerometer = new Accelerometer();

    //public AccelerometerAdapter()
    @Override
    public boolean up() {
        return accelerometer.getVerticalAxis() > 0;
    }

    @Override
    public boolean down() {
        return accelerometer.getVerticalAxis() < 0;
    }

    @Override
    public boolean left() {
        return accelerometer.getHorizontalAxis() < 0;
    }

    @Override
    public boolean right() {
        return accelerometer.getHorizontalAxis() > 0;
    }
}
