package org.example.convertor.impls.banner;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.impls.banner.DesignParameter;
import org.example.entities.impls.Banner;
import org.example.exception.ParameterConversionException;

public class DesignParameterConvertor extends AbstractParameterConverter<Banner> {
    public DesignParameterConvertor() {
        super("design");
    }

    @Override
    protected Parameter<Banner> internalConvert(String request) throws ParameterConversionException {
        return new DesignParameter(request);
    }
}