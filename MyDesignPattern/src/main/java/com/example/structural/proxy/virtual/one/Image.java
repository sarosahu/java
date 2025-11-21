package com.example.structural.proxy.virtual.one;

public abstract class Image {
    private String fileName;
    protected void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Image() {
    }
    public Image(String fileName) {
        this.fileName = fileName;
    }
    String getFileName() {
        return this.fileName;
    }
    public abstract void display();
    public abstract void load();
    public abstract void load(String fileName);
}
