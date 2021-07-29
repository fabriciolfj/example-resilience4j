package com.github.fabriciolfj.exampleresilience4j.api.controller;

import com.github.fabriciolfj.exampleresilience4j.api.dto.response.ProductResponse;
import com.github.fabriciolfj.exampleresilience4j.domain.exceptions.NotFoundException;
import com.github.fabriciolfj.exampleresilience4j.domain.exceptions.model.Error;
import com.github.fabriciolfj.exampleresilience4j.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponse find(@PathVariable("code") final String code) {
        var product = productService.find(code);
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProductResponse> find() {
        return productService.findAll()
                .stream()
                .map(product -> ProductResponse.builder()
                        .code(product.getCode())
                        .name(product.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> bussinessException(final NotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
