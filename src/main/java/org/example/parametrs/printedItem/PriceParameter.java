package org.example.parametrs.printedItem;

import org.example.parametrs.Parameter;
import org.example.entities.PrintedItem;

import java.security.InvalidParameterException;
import java.util.Objects;

public record PriceParameter<T extends PrintedItem>(double price) implements Parameter<T> {
    public PriceParameter {
        if (price < 0) {
            throw new InvalidParameterException("price can not be less than 0");
        }
    }

    @Override
    public boolean test(T printedItem) {
        return Objects.nonNull(printedItem) && price == printedItem.getPrice();
    }
}