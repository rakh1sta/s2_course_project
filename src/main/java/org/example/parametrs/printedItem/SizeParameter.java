package org.example.parametrs.printedItem;

import org.example.entities.PrintedItem;
import org.example.parametrs.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record SizeParameter<T extends PrintedItem>(String size) implements Parameter<T> {
    public SizeParameter {
        if (size == null || size.isBlank()) {
            throw new InvalidParameterException("Size can not be empty");
        }
    }

    @Override
    public boolean test(T printedItem) {
        return Objects.nonNull(printedItem) && printedItem.getSize().equals(size);
    }
}