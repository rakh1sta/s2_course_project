package org.example.searchingCriteria.impls;

import org.example.searchingCriteria.AbstractCriteria;
import org.example.entities.impls.EducationalMaterial;

public class EducationalMaterialsCriteria extends AbstractCriteria<EducationalMaterial> {
    @Override
    public Class<EducationalMaterial> getApplianceType() {
        return EducationalMaterial.class;
    }
}