package com.example.behavioral.observer.four;

public class Recorder implements OnValueChanged {

    @Override
    public void notify(ISensor sensor) {
        System.out.println("[RECORDER] " + sensor.getValue());
    }
}
