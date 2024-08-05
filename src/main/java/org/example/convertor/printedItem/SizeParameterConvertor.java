package org.example.convertor.printedItem;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.printedItem.SizeParameter;
import org.example.entities.PrintedItem;
import org.example.exception.ParameterConversionException;

public class SizeParameterConvertor<T extends PrintedItem>extends AbstractParameterConverter<T> {
    public SizeParameterConvertor() {
        super("size");
    }

    @Override
    protected Parameter<T> internalConvert(String request) throws ParameterConversionException {
        return new SizeParameter<>(request);
    }
}