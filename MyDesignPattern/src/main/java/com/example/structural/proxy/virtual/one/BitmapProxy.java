package com.example.structural.proxy.virtual.one;

public class BitmapProxy extends Image {
    private Image bitmap;
    //private Bitmap bitmap;
    private String fileName;
    private boolean isLoaded = false;

    public BitmapProxy() {
        this("");
    }
    public BitmapProxy(String fileName) {
        //super(fileName);
        bitmap = new Bitmap(fileName);
    }
    @Override
    public void display() {
        if (!isLoaded) {
            System.out.println("[Proxy] Loading Bitmap");
            if (fileName.isEmpty()) {
                bitmap.load();
            } else {
                bitmap.load(fileName);
            }
            isLoaded = true;
        }
        bitmap.display();
    }

    @Override
    public void load() {
        fileName = "";
    }

    @Override
    public void load(String fileName) {
        this.fileName = fileName;
    }
}
