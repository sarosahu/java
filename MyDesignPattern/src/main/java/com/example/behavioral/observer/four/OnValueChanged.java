package com.example.behavioral.observer.four;

// This is the Observer (Interface for sensor devices)
public interface OnValueChanged {
    public void notify(ISensor sensor);
}
