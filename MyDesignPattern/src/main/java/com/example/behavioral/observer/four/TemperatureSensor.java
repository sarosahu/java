package com.example.behavioral.observer.four;

import java.util.ArrayList;
import java.util.List;

// This is the subject (Observable)
public class TemperatureSensor implements ISensor{
    private ChangeManager changeManager;
    private float temperature;

    public TemperatureSensor(ChangeManager changeManager) {
        this.changeManager = changeManager;
    }

    public void setTemp(float value) {
        temperature = value;
        this.doNotify();
        System.out.println();
    }

    @Override
    public float getValue() {
        return this.temperature;
    }

    @Override
    public void doNotify() {
        changeManager.doNotify(this);
    }
}
