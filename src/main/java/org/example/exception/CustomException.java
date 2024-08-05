package org.example.exception;

import java.util.Objects;

public class CustomException extends RuntimeException {
    private final String method;
    private final Object[] args;
    private final Class<?> aClass;

    protected CustomException(String message, String method, Class<?> aClass, Object[] args) {
        super(message);
        this.method = method;
        this.args = args;
        this.aClass = aClass;
    }

    public CustomException(String text, String method) {
        this(text, method, null, null);
    }

    public String getMethodNAme() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Class<?> getaClass() {
        return aClass;
    }
}
