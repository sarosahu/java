package com.example.structural.adapter.two;

public class Accelerometer {

    // If a phone is tilted left, then it returns a -ve value
    // and if a phone is tilted right, then it returns a +ve value.
    protected double getHorizontalAxis() {
        return -1.0;
    }

    // If a phone is tilted forward, it will return +ve value.
    // and if it is tilted backward, then it will return -ve value.
    protected double getVerticalAxis() {
        return 1.0;
    }
}
