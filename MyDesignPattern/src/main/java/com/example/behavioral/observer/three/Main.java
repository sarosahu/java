package com.example.behavioral.observer.three;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        BillBoard bb = new BillBoard();
        SimpleDisplay sd = new SimpleDisplay();
        Recorder rd = new Recorder();

        sensor.register(TemperatureChange.LARGE, bb);
        sensor.register(TemperatureChange.LARGE, sd);
        sensor.register(TemperatureChange.SMALL, rd);

        sensor.setTemp(21.3f);
        sensor.setTemp(21.4f);
        sensor.setTemp(22.5f);
        sensor.setTemp(23.3f);

    }
}
