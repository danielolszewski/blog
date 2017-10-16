package com.dolszewski.blog.springcloud.author;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@RestController
class AuthorController {

    private final List<Author> authors = LongStream.rangeClosed(1, 3)
            .mapToObj(i -> new Author(i, "Author " + i))
            .collect(toList());

    @GetMapping
    List<Author> findAll() {
        return authors;
    }

    @GetMapping("/{id}")
    Author findOne(@PathVariable long id) {
        return authors.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

}
