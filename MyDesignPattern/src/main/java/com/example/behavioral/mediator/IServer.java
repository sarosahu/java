package com.example.behavioral.mediator;

public interface IServer {
    public void sendMessage(String from, String to, String message);
    public void register(String name, IParticipant participant);
    public void deregister(String name);
}
