package com.example.behavioral.state.orderexample;

public class Cancelled implements OrderState {
    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Cancelled order. Can't cancel anymore");
    }
}
