package org.example.convertor.printedItem;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.printedItem.ItemNameParameter;
import org.example.entities.PrintedItem;
import org.example.exception.ParameterConversionException;

public class ItemNameParameterConvertor<T extends PrintedItem> extends AbstractParameterConverter<T> {
    public ItemNameParameterConvertor() {
        super("itemName");
    }

    @Override
    protected Parameter<T> internalConvert(String request) throws ParameterConversionException {
        return new ItemNameParameter<>(request);
    }
}