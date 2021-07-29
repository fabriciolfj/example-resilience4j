package com.github.fabriciolfj.exampleresilience4j.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Product {

    private String code;
    private String name;

    public Product(final String name) {
        this.name = name;
        this.code = UUID.randomUUID().toString();
    }
}
