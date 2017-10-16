package com.dolszewski.blog.springcloud.author;

final class Author {

    private final Long id;
    private final String name;

    Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}