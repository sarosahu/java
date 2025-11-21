package com.example.behavioral.state.lampexample.third;

public class Lamp {
    private State state = new OffState();

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
