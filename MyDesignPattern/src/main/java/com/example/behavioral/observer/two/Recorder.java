package com.example.behavioral.observer.two;

public class Recorder implements OnValueChanged{
    @Override
    public void notify(float value) {
        System.out.println("[RECORDER] " + value);
    }
}
