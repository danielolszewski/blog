package com.dolszewski.blog;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Repository
class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        products = populateProducts();
    }

    List<Product> search(ProductCriteria criteria) {
        return products.stream()
                .filter(p -> p.getName().contains(criteria.getQuery()))
                .skip(criteria.getOffset())
                .limit(criteria.getLimit())
                .collect(toList());
    }

    private List<Product> populateProducts() {
        return IntStream.range(0, 50)
                .mapToObj(Product::new)
                .collect(toList());
    }

}
