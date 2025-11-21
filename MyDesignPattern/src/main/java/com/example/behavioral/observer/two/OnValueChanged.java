package com.example.behavioral.observer.two;

// This is the Observer (Interface for sensor devices)
public interface OnValueChanged {
    public void notify(float value);
}
