package org.example.convertor.printedItem;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.printedItem.MaterialParameter;
import org.example.entities.PrintedItem;
import org.example.exception.ParameterConversionException;

public class MaterialParameterConvertor<T extends PrintedItem>extends AbstractParameterConverter<T> {
    public MaterialParameterConvertor() {
        super("material");
    }

    @Override
    protected Parameter<T> internalConvert(String request) throws ParameterConversionException {
        return new MaterialParameter<>(request);
    }
}