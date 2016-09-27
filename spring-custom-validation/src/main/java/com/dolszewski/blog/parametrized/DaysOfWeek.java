package com.dolszewski.blog.parametrized;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DaysOfWeekValidator.class)
public @interface DaysOfWeek {

    String message() default "{com.dolszewski.blog.DaysOfWeek.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    DayOfWeek[] days() default {DayOfWeek.MONDAY};

}
