package com.example.creational.singleton;

import com.example.creational.singleton.eager.EagerRegistry;
import com.example.creational.singleton.enumway.RegistryEnum;
import com.example.creational.singleton.initializationholder.LazyRegistryIODH;
import com.example.creational.singleton.lazy.LazyRegistryWithDCL;

public class Client {
    public static void main(String[] args) {
        /*
        EagerRegistry registry = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();
        if (registry == registry2) {
            System.out.println("EagerRegistry : registry and registry2 are same");
        } else {
            System.out.println("EagerRegistry : registry and registry2 are not same");
        }

        LazyRegistryWithDCL lazyRegistry1 = LazyRegistryWithDCL.getInstance();
        LazyRegistryWithDCL lazyRegistry2 = LazyRegistryWithDCL.getInstance();
        if (lazyRegistry1 == lazyRegistry2) {
            System.out.println("LazyRegistryWithDCL : lazyRegistry1 and lazyRegistry2 are same");
        } else {
            System.out.println("LazyRegistryWithDCL : lazyRegistry1 and lazyRegistry2 are not same");
        }

        LazyRegistryIODH lazyRegistryIODH1 = LazyRegistryIODH.getInstance();
        LazyRegistryIODH lazyRegistryIODH2 = LazyRegistryIODH.getInstance();
        LazyRegistryIODH lazyRegistryIODH3 = LazyRegistryIODH.getInstance();
        if (lazyRegistryIODH1 == lazyRegistryIODH2) {
            System.out.println("LazyRegistryIODH : lazyRegistryIODH1 and lazyRegistryIODH2 are same");
        } else {
            System.out.println("LazyRegistryIODH : lazyRegistryIODH1 and lazyRegistryIODH2 are not same");
        }
        if (lazyRegistryIODH1 == lazyRegistryIODH3) {
            System.out.println("LazyRegistryIODH : lazyRegistryIODH1 and lazyRegistryIODH3 are same");
        } else {
            System.out.println("LazyRegistryIODH : lazyRegistryIODH1 and lazyRegistryIODH3 are not same");
        }

        RegistryEnum instance = RegistryEnum.INSTANCE;
        RegistryEnum instance2 = RegistryEnum.INSTANCE;
        System.out.println(instance2 instanceof RegistryEnum);
        if (instance == instance2) {
            System.out.println("RegistryEnum : instance and instance2 are the same");
        } else {
            System.out.println("RegistryEnum : instance and instance2 are not same");
        }
        */
        testLazyRegistryIODH();
        testRegistryEnum();
    }

    private static void testRegistryEnum() {
        System.out.println("Testing RegistryEnum");
        RegistryEnum instance = RegistryEnum.INSTANCE;
        instance.getConfiguration();
    }

    private static void testLazyRegistryIODH() {
        //LazyRegistryIODH lazyRegistryIODH = LazyRegistryIODH.getInstance();
        LazyRegistryIODH.printRegistry();
        LazyRegistryIODH lazyRegistryIODH = LazyRegistryIODH.getInstance();
    }
}
