package org.example.convertor;

import org.example.parametrs.Parameter;
import org.example.entities.PrintedItem;
import org.example.exception.ParameterConversionException;

public interface ParameterConverter<A extends PrintedItem> {
    Parameter<A> convert(String request) throws ParameterConversionException;
    String parameterName();
}
