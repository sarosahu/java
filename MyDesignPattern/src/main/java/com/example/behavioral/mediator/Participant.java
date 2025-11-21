package com.example.behavioral.mediator;

public abstract class Participant implements IParticipant{
    private String name;

    protected IServer server;

    // Use observer pattern : here participant is publisher
    // and the server will be the subscriber
    public void registerServer(IServer server) {
        this.server = server;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
