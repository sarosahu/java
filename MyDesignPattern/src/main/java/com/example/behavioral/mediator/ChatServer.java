package com.example.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatServer implements IServer{
    private Map<String, IParticipant> participants = new HashMap<>();

    @Override
    public void sendMessage(String from, String to, String message) {
        if (to.isEmpty()) {
            // broadcast message
            System.out.println("=========BROADCAST==========");
            participants.forEach((a, b) -> {
                    if (!a.equals(from)) {
                        b.receive(from, message);
                    }
                }
            );
        } else {
            participants.get(to).receive(from, message);
        }
    }

    @Override
    public void register(String name, IParticipant participant) {
        // Broadcast a message to other participants that
        // a new participant has joined.
        participants.forEach((a, b) -> {
            b.receive(name, " joined the chat!");
        });
        participants.put(name, participant);
    }

    @Override
    public void deregister(String name) {
        participants.remove(name);
        // Broadcast a message to other participants that
        // this particular participant has left the chat.
        participants.forEach((a, b) -> {
            b.receive(name, " left the chat!");
        });
    }
}
