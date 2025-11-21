package com.example.structural.proxy.virtual.one;

/**
 * Here we are calling load() as well as display().
 * However it may happen that client wants to load() the bitmap whenever there is a display() needed.
 * Hence if display() is not invoked, but load() is, then also we are allocating memory and loading the bitmap
 * which is unnecessary.
 * Hence we need a proxy here which will implement this design to prevent this issue (memory and processing of bitmap)
 * Because it will load the bitmap on demand. So this proxy will be virtual proxy.
 */
public class Main {
    public static void loadBitmapWithoutproxy() {
        Image image = new Bitmap("Proxy.txt");
        image.load();
        //image.display();
    }

    public static void loadBitmapWithproxy() {
        Image image = new BitmapProxy("Proxy.txt");
        image.load();
        //image.display();
    }

    public static void main(String[] args) {
        System.out.println("Invoking loadBitmapWithoutproxy() : --");
        loadBitmapWithoutproxy();
        System.out.println("loadBitmapWithoutproxy() DONE");

        System.out.println("Invoking loadBitmapWithproxy() : --");
        loadBitmapWithproxy();
        System.out.println("loadBitmapWithproxy() DONE");
    }
}
