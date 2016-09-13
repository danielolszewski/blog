package com.dolszewski.blog.part1;

import java.util.Objects;

public class User {

    @UniqueLogin
    private String login;
    private char[] password;

    private User() {
        // no-arg Jackson constructor
    }

    public User(String login, char[] password) {
        Objects.requireNonNull(login);
        Objects.requireNonNull(password);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

}
