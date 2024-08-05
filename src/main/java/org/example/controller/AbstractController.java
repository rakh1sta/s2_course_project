package org.example.controller;

import org.example.convertor.ParameterConverter;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.PrintedItem;
import org.example.service.PrintedItemService;
import org.example.service.ServiceFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class AbstractController<A extends PrintedItem> implements PrintedItemController<A> {

    private final PrintedItemService service;
    protected final Map<String, ParameterConverter<A>> parameterConverters;

    protected AbstractController(Map<String, ParameterConverter<A>> parameterConverters) {
        this.service = ServiceFactory.INSTANCE.getApplianceService();
        this.parameterConverters = parameterConverters;
    }

    @Override
    public List<String> getServiceParameterList() {
        return parameterConverters.keySet().stream().toList();
    }

    @Override
    public Collection<A> getData(Map<String, String> map) {
        return service.find(createCriteria(map));
    }

    @Override
    public Collection<A> findAll(Class<A> classType) {
        return service.findAll(classType);
    }

    protected abstract SearchCriteria<A> createCriteria(Map<String, String> criterias);


}
