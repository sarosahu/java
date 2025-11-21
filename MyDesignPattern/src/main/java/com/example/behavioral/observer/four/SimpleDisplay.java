package com.example.behavioral.observer.four;

public class SimpleDisplay implements OnValueChanged {
    @Override
    public void notify(ISensor sensor) {
        System.out.println("[SIMPLE DISPLAY] " + sensor.getValue());
    }
}
