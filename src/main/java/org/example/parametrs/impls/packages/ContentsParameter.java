package org.example.parametrs.impls.packages;

import org.example.parametrs.Parameter;
import org.example.entities.impls.Package;

import java.security.InvalidParameterException;
import java.util.Objects;

public record ContentsParameter(String contents) implements Parameter<Package> {
    public ContentsParameter {
        if (contents == null || contents.isBlank()) {
            throw new InvalidParameterException("Contents can not be empty");
        }
    }

    @Override
    public boolean test(Package aPackage) {
        return Objects.nonNull(aPackage) && aPackage.getContent().equals(contents);
    }
}