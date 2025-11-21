package com.example.behavioral.observer.four;

public class Main {
    public static void main(String[] args) {
        ChangeManager changeManager = new ChangeManager();
        TemperatureSensor temperatureSensor = new TemperatureSensor(changeManager);
        WindSpeedSensor windSpeedSensor = new WindSpeedSensor(changeManager);

        BillBoard bb = new BillBoard();
        SimpleDisplay sd = new SimpleDisplay();
        Recorder rd = new Recorder();

        changeManager.register(temperatureSensor, bb);
        changeManager.register(temperatureSensor, sd);
        changeManager.register(temperatureSensor, rd);
        changeManager.register(windSpeedSensor, bb);

        System.out.println("Temperature changing --->");
        temperatureSensor.setTemp(21.3f);
        temperatureSensor.setTemp(21.9f);
        temperatureSensor.setTemp(22.5f);
        temperatureSensor.setTemp(23.3f);

        System.out.println("Wind speed changing --->");
        windSpeedSensor.setSpeed(50);
        //
    }
}
