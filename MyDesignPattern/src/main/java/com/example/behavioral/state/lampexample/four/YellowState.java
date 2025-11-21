package com.example.behavioral.state.lampexample.four;

public class YellowState implements State {
    private static YellowState yellowState;
    private YellowState() {
        System.out.println("YellowState allocated.");
    }
    public static YellowState getYellowStateInstance() {
        if (yellowState == null) {
            yellowState = new YellowState();
        }
        return yellowState;
    }
    @Override
    public void switchOn(Lamp lamp) {
        System.out.println("Lamp --> [ON] --> WHITE color.");
        lamp.setState(StateFactory.getState("on_state"));
    }

    @Override
    public void switchOff(Lamp lamp) {
        System.out.println("Lamp --> [OFF] --> GRAY color.");
        lamp.setState(StateFactory.getState("off_state"));
    }
}
