package com.dolszewski.blog.product;

import java.util.Collection;

interface ProductRepository {
    Collection<Product> findAll();
}
