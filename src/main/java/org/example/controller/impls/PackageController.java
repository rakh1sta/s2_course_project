package org.example.controller.impls;

import org.example.controller.AbstractController;
import org.example.convertor.ParameterConverter;
import org.example.convertor.impls.packages.ContentParameterPackageConvertor;
import org.example.convertor.printedItem.*;
import org.example.searchingCriteria.impls.PackagesCriteria;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.Package;

import java.util.Collection;
import java.util.Map;

public class PackageController extends AbstractController<Package> {

    public PackageController() {
        super(Map.of("id", new IdParameterConvertor<>(),
                "itemName", new ItemNameParameterConvertor<>(),
                "material", new MaterialParameterConvertor<>(),
                "price", new PriceParameterConvertor<>(),
                "size", new SizeParameterConvertor<>(),
                "content", new ContentParameterPackageConvertor()));
    }

    @Override
    public Collection<Package> getData(Map<String, String> map) {
        return super.getData(map);
    }

    @Override
    public Collection<Package> findAll(Class<Package> classType) {
        return super.findAll(Package.class);
    }

    @Override
    protected SearchCriteria<Package> createCriteria(Map<String, String> map) {
        SearchCriteria<Package> searchCriteria = new PackagesCriteria();
        map.forEach((k, v) -> {
            ParameterConverter<Package> bannerParameterConverter = parameterConverters.get(k);
            searchCriteria.add(bannerParameterConverter.convert(v));
        });
        return searchCriteria;
    }
}