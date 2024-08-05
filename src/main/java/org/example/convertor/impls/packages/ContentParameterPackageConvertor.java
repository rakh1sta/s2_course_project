package org.example.convertor.impls.packages;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.impls.packages.ContentsParameter;
import org.example.entities.impls.Package;
import org.example.exception.ParameterConversionException;

public class ContentParameterPackageConvertor extends AbstractParameterConverter<Package> {
    public ContentParameterPackageConvertor() {
        super("content");
    }

    @Override
    protected Parameter<Package> internalConvert(String request) throws ParameterConversionException {
        return new ContentsParameter(request);
    }
}