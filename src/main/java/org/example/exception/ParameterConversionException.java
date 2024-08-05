package org.example.exception;

import java.lang.reflect.Method;

public class ParameterConversionException extends CustomException {
    public ParameterConversionException(String method) {
        this("Could not convert parameter", method);
    }

    public ParameterConversionException(String message, String method,Class<?> classType, Object ... args) {
        super(message, method,classType, args);
    }

    public ParameterConversionException(String text, String method) {
        super(text, method);
    }
}
