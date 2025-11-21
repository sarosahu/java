package com.example.creational.factorymethod;

public class TextMessageCreator extends MessageCreator{
    @Override
    protected Message createMessage() {
        return new TextMessage();
    }
}
