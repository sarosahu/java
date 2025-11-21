package com.example.creational.singleton.initializationholder;

public class LazyRegistryIODH {
    private LazyRegistryIODH() {
        System.out.println("LazyRegistryIODH() Constructor invoked.");
    }

    private static class RegistryHolder {
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }

    public static void printRegistry() {
        System.out.println("LazyRegistryIODH printRegistry() invoked.");
    }
}
