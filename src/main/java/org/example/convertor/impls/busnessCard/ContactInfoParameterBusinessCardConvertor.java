package org.example.convertor.impls.busnessCard;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.impls.busnessCard.ContactInfoParameter;
import org.example.entities.impls.BusinessCard;
import org.example.exception.ParameterConversionException;

public class ContactInfoParameterBusinessCardConvertor extends AbstractParameterConverter<BusinessCard> {
    public ContactInfoParameterBusinessCardConvertor() {
        super("contactInfo");
    }

    @Override
    protected Parameter<BusinessCard> internalConvert(String request) throws ParameterConversionException {
        return new ContactInfoParameter(request);
    }
}