package com.example.behavioral.state.lampexample.four;

public class OnState implements State {
    private static OnState onState;
    private OnState() {
        System.out.println("OnState allocated.");
    }
    public static OnState getOnStateInstance() {
        if (onState == null) {
            onState = new OnState();
        }
        return onState;
    }

    @Override
    public void switchOn(Lamp lamp) {
        //System.out.println("Already turned on");
        System.out.println("Lamp --> [ON] --> Yellow color.");
        lamp.setState(StateFactory.getState("yellow_state"));
    }

    @Override
    public void switchOff(Lamp lamp) {
        System.out.println("Lamp --> [OFF] --> GRAY color.");
        lamp.setState(StateFactory.getState("off_state"));
    }
}
