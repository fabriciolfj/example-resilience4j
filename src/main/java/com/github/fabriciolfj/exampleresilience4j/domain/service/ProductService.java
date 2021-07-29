package com.github.fabriciolfj.exampleresilience4j.domain.service;

import com.github.fabriciolfj.exampleresilience4j.domain.model.Product;
import com.github.fabriciolfj.exampleresilience4j.domain.repository.ProductRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product find(final String code) {
        return productRepository.find(code);
    }

    @Retry(name = "intervalFunctionExponentialExample", fallbackMethod = "findAllFallback")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllFallback(final Exception e) {
      log.info("Call fallback, exception: {}", e.getMessage());
      return Collections.EMPTY_LIST;
    }
}
