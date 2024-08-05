package org.example.dao.impls;

import org.example.dao.AbstractDAO;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.EducationalMaterial;
import org.example.parser.impls.EducationalMaterialParser;

import java.util.Collection;

public class EducationMaterialDAO extends AbstractDAO<EducationalMaterial> {
    public EducationMaterialDAO(String root) {
        super(root,"educational_material.csv", new EducationalMaterialParser());
    }

    @Override
    public Collection<EducationalMaterial> findAll(SearchCriteria<EducationalMaterial> criteria) {
        return super.findAll(criteria);
    }
}
