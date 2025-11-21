package com.example.behavioral.state.lampexample.second;

// Context class
public class Lamp {
    private State state = State.OFF;

    public void switchOn() {
        switch(state) {
            case OFF:
                System.out.println("Lamp --> [ON] --> WHITE color.");
                state = State.ON;
                break;
            case ON:
                System.out.println("Already [ON]");
                break;
        }
    }

    public void switchOff() {
        switch(state) {
            case OFF:
                System.out.println("Already [OFF]");
                break;
            case ON:
                System.out.println("Lamp --> [OFF] --> GRAY color.");
                state = State.OFF;
                break;
        }
    }
}
