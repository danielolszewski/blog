package com.dolszewski.blog.parametrized;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class DaysOfWeekValidator implements ConstraintValidator<DaysOfWeek, LocalDate> {

    private Set<DayOfWeek> validDays;

    public void initialize(DaysOfWeek constraint) {
        validDays = Arrays.stream(constraint.days()).collect(toSet());
    }

    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        return localDate != null && validDays.contains(localDate.getDayOfWeek());
    }

}
