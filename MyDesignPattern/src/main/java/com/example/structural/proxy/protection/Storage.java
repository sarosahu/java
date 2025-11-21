package com.example.structural.proxy.protection;

public interface Storage {
    public void createFile(String fileName);
    public void updateFile(String fileName);
    public void deleteFile(String fileName);
    public void viewFile(String fileName);
}
