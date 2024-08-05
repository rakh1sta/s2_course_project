package org.example.parametrs.printedItem;

import org.example.parametrs.Parameter;
import org.example.entities.PrintedItem;

import java.security.InvalidParameterException;
import java.util.Objects;

public record MaterialParameter<T extends PrintedItem>(String material) implements Parameter<T> {
    public MaterialParameter {
        if (material == null || material.isBlank()) {
            throw new InvalidParameterException("Material can not be empty");
        }
    }

    @Override
    public boolean test(T printedItem) {
        return Objects.nonNull(printedItem) && printedItem.getMaterial().equalsIgnoreCase(material);
    }
}