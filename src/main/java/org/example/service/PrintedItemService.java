package org.example.service;

import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.PrintedItem;

import java.util.Collection;

public interface PrintedItemService {
    <A extends PrintedItem> Collection<A> find(SearchCriteria<A> criteria);

    <A extends PrintedItem> Collection<A> findAll(Class<A> classType);
}