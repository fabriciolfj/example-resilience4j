package com.github.fabriciolfj.exampleresilience4j.domain.exceptions;

public class BussinessException extends RuntimeException {

    public BussinessException(final String msg) {
        super(msg);
    }
}
