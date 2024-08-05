package org.example.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface PrintedItemController<A> {
    List<String> getServiceParameterList();
    Collection<A> getData(Map<String, String> map);
    Collection<A> findAll(Class<A> classType);

}
