package org.example.convertor;

import org.example.entities.PrintedItem;
import org.example.parametrs.Parameter;
import org.example.exception.ParameterConversionException;

public abstract class AbstractParameterConverter<A extends PrintedItem>
        implements ParameterConverter<A> {
    private final String parameterName;

    protected AbstractParameterConverter(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public Parameter<A> convert(String request) throws ParameterConversionException {
        try {
            return internalConvert(request);
        } catch (ParameterConversionException e) {
            throw new ParameterConversionException(e.getMessage());
        }
    }

    protected abstract Parameter<A> internalConvert(String request)
            throws ParameterConversionException;

    @Override
    public String parameterName() {
        return parameterName;
    }
}