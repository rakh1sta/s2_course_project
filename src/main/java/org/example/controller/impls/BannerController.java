package org.example.controller.impls;

import org.example.controller.AbstractController;
import org.example.convertor.ParameterConverter;
import org.example.convertor.impls.banner.*;
import org.example.convertor.printedItem.*;
import org.example.searchingCriteria.impls.BannerCriteria;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.Banner;

import java.util.Collection;
import java.util.Map;

public class BannerController extends AbstractController<Banner> {

    public BannerController() {
        super(Map.of("id", new IdParameterConvertor<>(),
                "itemName", new ItemNameParameterConvertor<>(),
                "material", new MaterialParameterConvertor<>(),
                "price", new PriceParameterConvertor<>(),
                "size", new SizeParameterConvertor<>(),
                "design", new DesignParameterConvertor()));
    }

    @Override
    public Collection<Banner> getData(Map<String, String> map) {
        return super.getData(map);
    }

    @Override
    public Collection<Banner> findAll(Class<Banner> classType) {
        return super.findAll(Banner.class);
    }

    @Override
    protected SearchCriteria<Banner> createCriteria(Map<String, String> map) {
        SearchCriteria<Banner> searchCriteria = new BannerCriteria();
        map.forEach((k, v) -> {
            ParameterConverter<Banner> bannerParameterConverter = parameterConverters.get(k);
            searchCriteria.add(bannerParameterConverter.convert(v));
        });
        return searchCriteria;
    }

}
