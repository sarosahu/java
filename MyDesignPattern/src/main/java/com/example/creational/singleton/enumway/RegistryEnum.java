package com.example.creational.singleton.enumway;

// It handles deserialization very well , meaning it doesn't create new instance while doing deserialization.
public enum RegistryEnum {
    INSTANCE;
    public void getConfiguration() {
        System.out.println("Configuration.");
    }
}
