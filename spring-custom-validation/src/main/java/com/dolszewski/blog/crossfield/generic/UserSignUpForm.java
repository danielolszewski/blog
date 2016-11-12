package com.dolszewski.blog.crossfield.generic;

import java.util.Objects;

@EqualFields(baseField = "password", matchField = "confirmedPassword")
public class UserSignUpForm {

    private String login;
    private String password;
    private String confirmedPassword;

    public UserSignUpForm(String login, String password, String confirmedPassword) {
        Objects.requireNonNull(login);
        Objects.requireNonNull(password);
        Objects.requireNonNull(confirmedPassword);
        this.login = login;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

}
