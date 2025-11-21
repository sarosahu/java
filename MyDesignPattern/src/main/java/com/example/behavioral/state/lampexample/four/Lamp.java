package com.example.behavioral.state.lampexample.four;

public class Lamp {
    private State state = OffState.getOffStateInstance();

    public void switchOn() {
        this.state.switchOn(this);
    }

    public void switchOff() {
        this.state.switchOff(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
