package com.example.creational.abstractfactory.google;

import com.example.creational.abstractfactory.Instance;
import com.example.creational.abstractfactory.ResourceFactory;
import com.example.creational.abstractfactory.Storage;

public class GoogleResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
