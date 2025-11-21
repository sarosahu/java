package com.example.behavioral.observer.three;

public class SimpleDisplay implements OnValueChanged {
    @Override
    public void notify(float value) {
        System.out.println("[SIMPLEDISPLAY] " + value);
    }
}
