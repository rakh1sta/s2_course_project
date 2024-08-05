package org.example.convertor.impls.educatoinalMaterial;

import org.example.convertor.AbstractParameterConverter;
import org.example.parametrs.Parameter;
import org.example.parametrs.impls.educatoinalMaterial.SubjectParameter;
import org.example.entities.impls.EducationalMaterial;
import org.example.exception.ParameterConversionException;

public class SubjectParameterEducationalMaterialConvertor extends AbstractParameterConverter<EducationalMaterial> {
    public SubjectParameterEducationalMaterialConvertor() {
        super("subject");
    }

    @Override
    protected Parameter<EducationalMaterial> internalConvert(String request) throws ParameterConversionException {
        return new SubjectParameter(request);
    }
}