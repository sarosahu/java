package com.example.behavioral.observer.three;

public class BillBoard implements OnValueChanged {
    @Override
    public void notify(float value) {
        System.out.println("[BILLBOARD] " + value);
    }
}
