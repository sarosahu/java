package com.example.behavioral.observer.two;

import java.util.ArrayList;
import java.util.List;

// This is the subject (Observable)
public class TemperatureSensor {
    private List<OnValueChanged> subscribers = new ArrayList<>();
    private float temperature;

    public void register(OnValueChanged onValueChanged) {
        subscribers.add(onValueChanged);
    }

    public void deregister(OnValueChanged onValueChanged) {
        subscribers.remove(onValueChanged);
    }

    public void notify(float value) {
        for (OnValueChanged sensor : subscribers) {
            sensor.notify(value);
        }
        System.out.println();
    }

    public void setTemp(float value) {
        temperature = value;
        this.notify(value);
    }
}
