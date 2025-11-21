package com.example.creational.factorymethod;

public class JsonMessage extends Message {
    @Override
    public String getContent() {
        return "{\"JSON]\":[]}";
    }
}
