package com.example.behavioral.mediator;

public class ChatSystem {
    public static void main(String[] args) {
        // We can have only one chat server, so it can be implemented as singleton
        ChatServer chatServer = new ChatServer();
        Person p1 = new Person();
        p1.setName("Saroj");

        Person p2 = new Person();
        p2.setName("Sachin");

        Person p3 = new Person();
        p3.setName("Sourav");

        // Register the observer (ChatServer) to all the participants
        p1.registerServer(chatServer);
        p2.registerServer(chatServer);
        p3.registerServer(chatServer);

        // Saroj is logging in
        chatServer.register(p1.getName(), p1);
        // Sachin is logging in
        chatServer.register(p2.getName(), p2);
        // Sourav is logging in
        chatServer.register(p3.getName(), p3);

        System.out.println("\nCommunication between participants\n");
        p1.send(p2.getName(), "Hi there");
        p2.send(p1.getName(), "Hello");
        p3.send("", "Hi everyone");

        System.out.println("\n" + p3.getName() + " is going to leave the chat system.");
        chatServer.deregister(p3.getName());
    }
}
