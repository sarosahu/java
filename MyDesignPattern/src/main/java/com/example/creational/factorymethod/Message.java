package com.example.creational.factorymethod;

public abstract class Message {
    public abstract String getContent();

    public void addDefaultHeaders() {
        // Add some default headers
    }

    public void encrypt() {
        // Add encryption logic
    }
}
