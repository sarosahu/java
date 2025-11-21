package com.example.behavioral.observer.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This is the subject (Observable)
public class TemperatureSensor {
    private Map<TemperatureChange, List<OnValueChanged>> subscribers = new HashMap<>();
    private float temperature;
    private float changeInTemperature;

    private void notify(TemperatureChange tc) {
        subscribers.get(tc).forEach(sub -> {
            sub.notify(temperature);
        });
    }

    public void register(TemperatureChange tc, OnValueChanged onValueChanged) {
        if (!subscribers.containsKey(tc)) {
            subscribers.put(tc, new ArrayList<>());
        }
        subscribers.get(tc).add(onValueChanged);
    }

    public void deregister(TemperatureChange tc, OnValueChanged onValueChanged) {
        subscribers.get(tc).remove(onValueChanged);
    }

    public void notify(float value) {
        if (changeInTemperature > 0.5f) {
            this.notify(TemperatureChange.LARGE);
        }
        this.notify(TemperatureChange.SMALL);
        System.out.println();
    }

    public void setTemp(float value) {
        System.out.println("Temperature has been modified [" + value + "]");
        changeInTemperature = Math.abs(temperature - value);
        temperature = value;
        this.notify(value);
    }
}
