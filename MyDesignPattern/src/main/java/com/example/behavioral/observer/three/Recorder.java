package com.example.behavioral.observer.three;

public class Recorder implements OnValueChanged {
    @Override
    public void notify(float value) {
        System.out.println("[RECORDER] " + value);
    }
}
