package org.example.searchingCriteria;


import org.example.parametrs.Parameter;
import org.example.entities.PrintedItem;

public interface SearchCriteria<E extends PrintedItem> {

    Class<E> getApplianceType();

    <P extends Parameter<E>> SearchCriteria<E> add(P parameter);

    boolean test(E printedItem);
}
