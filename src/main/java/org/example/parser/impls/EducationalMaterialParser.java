package org.example.parser.impls;

import org.example.entities.impls.EducationalMaterial;
import org.example.parser.AbstractParser;

public class EducationalMaterialParser extends AbstractParser<EducationalMaterial> {
    @Override
    protected EducationalMaterial parse(String[] rowData) {
        return new EducationalMaterial.Builder()
                .id(Long.parseLong(rowData[0]))
                .itemName(rowData[1])
                .price(Double.parseDouble(rowData[2]))
                .material(rowData[3])
                .size(rowData[4])
                .subject(rowData[5])
                .build();
    }
}
