package org.example.parametrs.printedItem;

import org.example.parametrs.Parameter;
import org.example.entities.PrintedItem;

import java.security.InvalidParameterException;
import java.util.Objects;

public record ItemNameParameter<T extends PrintedItem>(String itemName) implements Parameter<T> {
    public ItemNameParameter {
        if (itemName == null || itemName.isBlank()) {
            throw new InvalidParameterException("item name can not be empty");
        }
    }

    @Override
    public boolean test(T printedItem) {
        return Objects.nonNull(printedItem)
                && printedItem.getItemName().toLowerCase().contains(itemName.toLowerCase());
    }
}