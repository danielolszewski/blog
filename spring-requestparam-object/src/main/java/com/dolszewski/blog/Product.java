package com.dolszewski.blog;

final class Product {

    private final long id;
    private final String name;

    Product(long id) {
        this.id = id;
        name = "Product " + id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
