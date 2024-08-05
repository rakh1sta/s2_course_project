package org.example.dao.impls;

import org.example.dao.AbstractDAO;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.BusinessCard;
import org.example.parser.impls.BusinessCardParser;

import java.util.Collection;

public class BusinessCardDAO extends AbstractDAO<BusinessCard> {
    public BusinessCardDAO(String root) {
        super(root,"business_card.csv", new BusinessCardParser());
    }

    @Override
    public Collection<BusinessCard> findAll(SearchCriteria<BusinessCard> criteria) {
        return super.findAll(criteria);
    }
}
