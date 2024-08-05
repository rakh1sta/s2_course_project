package org.example.searchingCriteria;

import org.example.entities.PrintedItem;
import org.example.parametrs.Parameter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends PrintedItem>
        implements SearchCriteria<A> {

    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(A printedItem) {
        return parameters.values().stream().allMatch(p -> p.test(printedItem));
    }
}
