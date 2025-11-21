package com.example.behavioral.observer.four;

public class WindSpeedSensor implements ISensor{

    private float speed;
    ChangeManager changeManager;

    WindSpeedSensor(ChangeManager changeManager) {
        this.changeManager = changeManager;
    }

    @Override
    public float getValue() {
        return speed;
    }

    @Override
    public void doNotify() {
        changeManager.doNotify(this);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
        this.doNotify();
    }
}
