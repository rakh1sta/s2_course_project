package org.example.exception;

import java.util.Objects;

public class MisMatchInputException extends CustomException {
    public MisMatchInputException(String method, Class<?> classType, Object... args) {
        this("The input parameter did not match",method,classType, args);
    }

    protected MisMatchInputException(String text,String method, Class<?> classType, Object... args) {
        super(text, method,classType, args);
    }
}
