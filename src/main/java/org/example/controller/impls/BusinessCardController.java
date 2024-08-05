package org.example.controller.impls;

import org.example.controller.AbstractController;
import org.example.convertor.ParameterConverter;
import org.example.convertor.impls.busnessCard.*;
import org.example.convertor.printedItem.*;
import org.example.searchingCriteria.impls.BusinessCardsCriteria;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.BusinessCard;

import java.util.Collection;
import java.util.Map;

public class BusinessCardController extends AbstractController<BusinessCard> {

    public BusinessCardController() {
        super(Map.of("id", new IdParameterConvertor<>(),
                "itemName", new ItemNameParameterConvertor<>(),
                "material", new MaterialParameterConvertor<>(),
                "price", new PriceParameterConvertor<>(),
                "size", new SizeParameterConvertor<>(),
                "contactInfo", new ContactInfoParameterBusinessCardConvertor()));
    }

    @Override
    public Collection<BusinessCard> findAll(Class<BusinessCard> classType) {
        return super.findAll(BusinessCard.class);
    }

    @Override
    public Collection<BusinessCard> getData(Map<String, String> map) {
        return super.getData(map);
    }

    @Override
    protected SearchCriteria<BusinessCard> createCriteria(Map<String, String> map) {
        SearchCriteria<BusinessCard> searchCriteria = new BusinessCardsCriteria();
        map.forEach((k, v) -> {
            ParameterConverter<BusinessCard> bannerParameterConverter = parameterConverters.get(k);
            searchCriteria.add(bannerParameterConverter.convert(v));
        });
        return searchCriteria;
    }
}