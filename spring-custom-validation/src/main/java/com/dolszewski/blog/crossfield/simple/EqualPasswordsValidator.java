package com.dolszewski.blog.crossfield.simple;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, UserSignUpForm> {

    @Override
    public void initialize(EqualPasswords constraint) {
    }

    @Override
    public boolean isValid(UserSignUpForm form, ConstraintValidatorContext context) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }

}
