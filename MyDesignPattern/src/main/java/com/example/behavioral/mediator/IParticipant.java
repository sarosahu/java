package com.example.behavioral.mediator;

public interface IParticipant {
    public void send(String to, String message);
    public void receive(String from, String message);
}
