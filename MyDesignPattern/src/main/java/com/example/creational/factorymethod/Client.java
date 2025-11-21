package com.example.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        printMessage(new TextMessageCreator());
        printMessage(new JsonMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg);
    }
}
