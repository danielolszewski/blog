package com.dolszewski.blog.basic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    private UserRepository userRepository;

    public UniqueLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(UniqueLogin constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !userRepository.findByLogin(login).isPresent();
    }

}
