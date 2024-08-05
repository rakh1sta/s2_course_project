package org.example.searchingCriteria.impls;

import org.example.searchingCriteria.AbstractCriteria;
import org.example.entities.impls.BusinessCard;

public class BusinessCardsCriteria extends AbstractCriteria<BusinessCard> {
    @Override
    public Class<BusinessCard> getApplianceType() {
        return BusinessCard.class;
    }
}