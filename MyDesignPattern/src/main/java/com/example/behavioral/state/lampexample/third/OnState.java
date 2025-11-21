package com.example.behavioral.state.lampexample.third;

public class OnState implements State{
    @Override
    public void switchOn(Lamp lamp) {
        //System.out.println("Already turned on");
        System.out.println("Lamp --> [ON] --> Yellow color.");
        lamp.setState(new YellowState());
    }

    @Override
    public void switchOff(Lamp lamp) {
        System.out.println("Lamp --> [OFF] --> GRAY color.");
        lamp.setState(new OffState());
    }
}
