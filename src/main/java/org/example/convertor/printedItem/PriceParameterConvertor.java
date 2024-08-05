package org.example.convertor.printedItem;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.printedItem.PriceParameter;
import org.example.entities.PrintedItem;
import org.example.exception.ParameterConversionException;

public class PriceParameterConvertor<T extends PrintedItem>extends AbstractParameterConverter<T> {
    public PriceParameterConvertor() {
        super("price");
    }

    @Override
    protected Parameter<T> internalConvert(String request) throws ParameterConversionException {
        return new PriceParameter<>(Double.parseDouble(request));
    }
}