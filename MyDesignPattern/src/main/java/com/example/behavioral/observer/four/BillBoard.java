package com.example.behavioral.observer.four;

public class BillBoard implements OnValueChanged {

    @Override
    public void notify(ISensor sensor) {
        System.out.println("[BILLBOARD] " + sensor.getValue());
    }
}
