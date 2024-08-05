package org.example.parametrs.impls.educatoinalMaterial;

import org.example.entities.impls.EducationalMaterial;
import org.example.parametrs.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record SubjectParameter(String subject) implements Parameter<EducationalMaterial> {
    public SubjectParameter {
        if (subject == null || subject.isBlank()) {
            throw new InvalidParameterException("Subject can not be empty");
        }
    }

    @Override
    public boolean test(EducationalMaterial educationalMaterials) {
        return Objects.nonNull(educationalMaterials) &&  educationalMaterials.getSubject().equals(subject);
    }
}