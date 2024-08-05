package org.example.parametrs.printedItem;

import org.example.entities.PrintedItem;
import org.example.parametrs.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record IdParameter<T extends PrintedItem>(long id) implements Parameter<T> {
    public IdParameter {
        if (id < 0) {
            throw new InvalidParameterException("Id can not be less than 0");
        }
    }

    @Override
    public boolean test(T printedItem) {
        return Objects.nonNull(printedItem) &&  printedItem.getId() == id;
    }
}
