package org.example.service;

import org.example.dao.DaoFactory;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.PrintedItem;

import java.util.Collection;
import java.util.Objects;

public enum ServiceFactory {
    INSTANCE;

    public PrintedItemService getApplianceService() {
        return new PrintedItemService() {
            @Override
            public <A extends PrintedItem> Collection<A> find(SearchCriteria<A> criteria) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(criteria.getApplianceType()))
                        .findAll(criteria);
            }

            @Override
            public <A extends PrintedItem> Collection<A> findAll(Class<A> classType) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(classType))
                        .findAll();
            }
        };
    }
}
