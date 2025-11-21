package com.example.behavioral.state.lampexample.four;

public class OffState implements State {
    private static OffState offState;
    private OffState() {
        System.out.println("OffState allocated.");
    }
    public static OffState getOffStateInstance() {
        if (offState == null) {
            offState = new OffState();
        }
        return offState;
    }
    @Override
    public void switchOn(Lamp lamp) {
        System.out.println("Lamp --> [ON] --> WHITE color.");
        lamp.setState(StateFactory.getState("on_state"));
    }

    @Override
    public void switchOff(Lamp lamp) {
        System.out.println("Already turned off");
    }
}
