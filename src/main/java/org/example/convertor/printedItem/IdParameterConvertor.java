package org.example.convertor.printedItem;

import org.example.convertor.AbstractParameterConverter;
import org.example.entities.PrintedItem;
import org.example.parametrs.Parameter;
import org.example.parametrs.printedItem.IdParameter;
import org.example.exception.ParameterConversionException;

public class IdParameterConvertor<T extends PrintedItem> extends AbstractParameterConverter<T> {
    public IdParameterConvertor() {
        super("id");
    }

    @Override
    protected Parameter<T> internalConvert(String request) throws ParameterConversionException {
        return new IdParameter<T>(Long.parseLong(request));
    }
}
