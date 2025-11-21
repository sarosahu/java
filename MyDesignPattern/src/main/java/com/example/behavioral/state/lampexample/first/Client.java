package com.example.behavioral.state.lampexample.first;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Lamp lamp = new Lamp();
        lamp.switchOn();
        Thread.sleep(1000);
        lamp.switchOff();
        Thread.sleep(1000);

        // What if lamp is switched off again ? Let's check
        lamp.switchOff();
    }
}
