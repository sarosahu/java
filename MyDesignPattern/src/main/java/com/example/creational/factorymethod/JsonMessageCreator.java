package com.example.creational.factorymethod;

public class JsonMessageCreator extends MessageCreator {
    @Override
    protected Message createMessage() {
        return new JsonMessage();
    }
}
