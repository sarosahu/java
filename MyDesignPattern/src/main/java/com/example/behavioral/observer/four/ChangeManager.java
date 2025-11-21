package com.example.behavioral.observer.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Mediator -- this class maintains mapping between observer and it's subject
public class ChangeManager {
    private Map<ISensor, List<OnValueChanged>> mappings = new HashMap<>();

    public void register(ISensor sensor, OnValueChanged onValueChanged) {
        if (!mappings.containsKey(sensor)) {
            mappings.put(sensor, new ArrayList<>());
        }
        mappings.get(sensor).add(onValueChanged);
    }

    public void deregister(ISensor sensor, OnValueChanged onValueChanged) {
        mappings.get(sensor).remove(onValueChanged);
    }

    public void doNotify(ISensor sensor) {
        for (OnValueChanged observer : mappings.get(sensor)) {
            observer.notify(sensor);
        }
    }
}
