package org.example.controller.impls;

import org.example.controller.AbstractController;
import org.example.convertor.ParameterConverter;
import org.example.convertor.impls.educatoinalMaterial.SubjectParameterEducationalMaterialConvertor;
import org.example.convertor.printedItem.*;
import org.example.searchingCriteria.impls.EducationalMaterialsCriteria;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.EducationalMaterial;

import java.util.Collection;
import java.util.Map;

public class EducationMaterialController extends AbstractController<EducationalMaterial> {

    public EducationMaterialController() {
        super(Map.of("id", new IdParameterConvertor<>(),
                        "itemName", new ItemNameParameterConvertor<>(),
                        "material", new MaterialParameterConvertor<>(),
                        "price", new PriceParameterConvertor<>(),
                        "size", new SizeParameterConvertor<>(),
                        "subject", new SubjectParameterEducationalMaterialConvertor()));
    }

    @Override
    public Collection<EducationalMaterial> getData(Map<String, String> map) {
        return super.getData(map);
    }

    @Override
    public Collection<EducationalMaterial> findAll(Class<EducationalMaterial> classType) {
        return super.findAll(EducationalMaterial.class);
    }

    @Override
    protected SearchCriteria<EducationalMaterial> createCriteria(Map<String, String> map) {
        SearchCriteria<EducationalMaterial> searchCriteria = new EducationalMaterialsCriteria();
        map.forEach((k, v) -> {
            ParameterConverter<EducationalMaterial> bannerParameterConverter = parameterConverters.get(k);
            searchCriteria.add(bannerParameterConverter.convert(v));
        });
        return searchCriteria;
    }
}