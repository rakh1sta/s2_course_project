package org.example.parametrs.impls.busnessCard;

import org.example.entities.impls.BusinessCard;
import org.example.parametrs.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record ContactInfoParameter(String contactInfo) implements Parameter<BusinessCard> {
    public ContactInfoParameter {
        if (contactInfo == null || contactInfo.isBlank()) {
            throw new InvalidParameterException("Contact info can not be empty");
        }
    }

    @Override
    public boolean test(BusinessCard businessCards) {
        return Objects.nonNull(businessCards) &&  contactInfo.equals(businessCards.getContactInfo());
    }
}