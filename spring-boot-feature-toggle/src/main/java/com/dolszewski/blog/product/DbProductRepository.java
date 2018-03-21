package com.dolszewski.blog.product;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Repository
@ConditionalOnProperty(
        name = "feature.toggles.productsFromWebService",
        havingValue = "false",
        matchIfMissing = true
)
class DbProductRepository implements ProductRepository {

    @Override
    public Collection<Product> findAll() {
        return IntStream.range(1, 6)
                .mapToObj(i -> "Db product " + i)
                .map(Product::new)
                .collect(toList());
    }

}
