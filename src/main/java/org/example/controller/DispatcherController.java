package org.example.controller;

import org.example.exception.WrongInputException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DispatcherController {
    private static DispatcherController instance;
    private final Map<Class<?>, PrintedItemController<?>> controllers;

    private DispatcherController(Map<Class<?>, PrintedItemController<?>> controllers) {
        this.controllers = controllers;
    }

    public List<String> getControllerTypes() {
        return controllers.keySet().stream().map(Class::getSimpleName).toList();
    }


    public PrintedItemController<?> getController(int index, String methodName) {
        if (index < 0 || index >= controllers.size())
            throw new WrongInputException(methodName);
        return controllers.values().stream().toList().get(index);
    }

    public static DispatcherController getInstance(Map<Class<?>, PrintedItemController<?>> controllers) {
        if (instance == null) {
            instance = new DispatcherController(controllers);
            return instance;
        }
        return instance;
    }
}