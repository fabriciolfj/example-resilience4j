package com.github.fabriciolfj.exampleresilience4j.domain.repository;

import com.github.fabriciolfj.exampleresilience4j.domain.exceptions.BussinessException;
import com.github.fabriciolfj.exampleresilience4j.domain.exceptions.NotFoundException;
import com.github.fabriciolfj.exampleresilience4j.domain.model.Product;
import com.github.fabriciolfj.exampleresilience4j.infra.RandomUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {

    private static List<Product> products =
            List.of(new Product("arroz"),
                    new Product("batata"),
                    new Product("Azeitona"),
                    new Product("farinha"));

    public Product find(final String code) {
        errorRandom();

        return products.stream().filter(p -> p.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product not found, by code " + code));
    }

    public List<Product> findAll() {
        errorRandom();
        return products;
    }

    private void errorRandom() {
        if (!RandomUtil.isValid()) {
            throw new BussinessException("Error find products");
        }
    }

}
