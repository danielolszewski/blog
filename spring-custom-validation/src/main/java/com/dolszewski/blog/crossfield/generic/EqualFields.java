package com.dolszewski.blog.crossfield.generic;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualFieldsValidator.class})
public @interface EqualFields {

    String message() default "{com.dolszewski.blog.EqualFields.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String baseField();

    String matchField();

}
