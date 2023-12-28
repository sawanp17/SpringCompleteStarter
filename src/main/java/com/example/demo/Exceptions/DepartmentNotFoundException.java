package com.example.demo.Exceptions;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(final String message) {
        super(message);
    }

    public DepartmentNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(final Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
