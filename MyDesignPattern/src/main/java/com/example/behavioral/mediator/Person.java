package com.example.behavioral.mediator;

public class Person extends Participant {
    @Override
    public void send(String to, String message) {
        server.sendMessage(getName(), to, message);
    }

    @Override
    public void receive(String from, String message) {
        // Print the message
        System.out.println(getName() + " received message: " + "[" + from + "]" + message);
    }
}
