package com.example.creational.abstractfactory.aws;

import com.example.creational.abstractfactory.Instance;
import com.example.creational.abstractfactory.ResourceFactory;
import com.example.creational.abstractfactory.Storage;

//Factory implementation for AWS resources
public class AwsResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
