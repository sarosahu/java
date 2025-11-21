package com.example.creational.abstractfactory;

public interface ResourceFactory {
    Instance createInstance(Instance.Capacity capacity);

    Storage createStorage(int capMib);
}
