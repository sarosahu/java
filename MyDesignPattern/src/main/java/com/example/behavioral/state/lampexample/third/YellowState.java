package com.example.behavioral.state.lampexample.third;

public class YellowState implements State{
    @Override
    public void switchOn(Lamp lamp) {
        System.out.println("Lamp --> [ON] --> WHITE color.");
        lamp.setState(new OnState());
    }

    @Override
    public void switchOff(Lamp lamp) {
        System.out.println("Lamp --> [OFF] --> GRAY color.");
        lamp.setState(new OffState());
    }
}
