package com.github.fabriciolfj.exampleresilience4j.domain.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final String msg) {
        super(msg);
    }
}
