package com.example.behavioral.observer.two;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        BillBoard bb = new BillBoard();
        SimpleDisplay sd = new SimpleDisplay();
        Recorder rd = new Recorder();

        sensor.register(bb);
        sensor.register(sd);
        sensor.register(rd);

        // Here on every change on temperature, all the observers (sensor devices)
        // are notified, and they are being displayed
        // {
        sensor.setTemp(21.3f);
        sensor.setTemp(21.9f);
        sensor.setTemp(22.5f);
        sensor.setTemp(23.3f);
        // }
        // But assume that Billboard and simplerDisplay are not interested in
        // displaying the temperature if the change in temperature is very less
        // But the recorder will have to log each temperature details into its DB.
        // How will you do it ? --> Refer package three
        //
    }
}
