package com.dolszewski.blog.springcloud.article;

final class Article {

    private final Long id;
    private final String title;
    private final String content;

    Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}