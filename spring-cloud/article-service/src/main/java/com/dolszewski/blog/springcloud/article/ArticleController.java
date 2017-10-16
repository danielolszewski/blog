package com.dolszewski.blog.springcloud.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@RestController
class ArticleController {

    private final List<Article> articles = LongStream.rangeClosed(1, 5)
            .mapToObj(i -> new Article(i, "Title " + i, "Content " + i))
            .collect(toList());

    @GetMapping
    List<Article> findAll() {
        return articles;
    }

    @GetMapping("/{id}")
    Article findOne(@PathVariable long id) {
        return articles.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

}
