package com.example.creational.singleton.lazy;

public class LazyRegistryWithDCL {
    private LazyRegistryWithDCL() {}
    // TO make sure we don't get the value from CPU cache, but from main memory
    // declare it as volatile as well.
    private static volatile LazyRegistryWithDCL INSTANCE;

    public static LazyRegistryWithDCL getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyRegistryWithDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDCL();
                }
            }
        }
        return INSTANCE;
    }
}
