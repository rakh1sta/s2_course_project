package org.example.dao;

import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.PrintedItem;

import java.util.Collection;

public interface PrintedItemDAO<A extends PrintedItem> {
    Collection<A> findAll(SearchCriteria<A> criteria);
    Collection<A> findAll();
}
