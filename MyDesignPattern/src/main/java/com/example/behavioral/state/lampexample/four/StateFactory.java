package com.example.behavioral.state.lampexample.four;

public class StateFactory {
    public static State getState(String stateType) {
        OnState onState = OnState.getOnStateInstance();
        OffState offState = OffState.getOffStateInstance();
        YellowState yellowState = YellowState.getYellowStateInstance();

        if (stateType.equals("on_state")) {
            return onState;
        } else if (stateType.equals("off_state")) {
            return offState;
        } else if (stateType.equals("yellow_state")) {
            return yellowState;
        }
        throw new RuntimeException("Unknown state requested.");
    }
}
