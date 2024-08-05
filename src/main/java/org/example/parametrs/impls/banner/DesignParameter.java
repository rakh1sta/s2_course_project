package org.example.parametrs.impls.banner;

import org.example.entities.impls.Banner;
import org.example.parametrs.Parameter;
import org.example.exception.ParameterConversionException;

import java.util.Objects;

public record DesignParameter(String design) implements Parameter<Banner> {
    public DesignParameter {
        if (design == null || design.isBlank()) {
            throw new ParameterConversionException("Design can not be empty");
        }
    }

    @Override
    public boolean test(Banner banner) {
        return Objects.nonNull(banner) && banner.getDesign().toLowerCase().contains(design.toLowerCase());
    }
}