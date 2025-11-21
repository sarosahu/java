package com.example.creational.abstractfactory.google;

import com.example.creational.abstractfactory.Storage;

public class GoogleCloudStorage implements Storage {
    public GoogleCloudStorage(int capacityInMib) {
        //Use gcp api
        System.out.println("Allocated "+capacityInMib+" on Google Cloud Storage");
    }

    @Override
    public String getId() {
        return "gcpcs1";
    }

    @Override
    public String toString() {
        return "Google cloud storage";
    }
}
