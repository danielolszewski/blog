package com.dolszewski.blog.multitype;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public abstract class DaysOfWeekValidator<T> implements ConstraintValidator<DaysOfWeek, T> {

    private Set<DayOfWeek> validDays;

    @Override
    public void initialize(DaysOfWeek constraint) {
        validDays = Arrays.stream(constraint.days()).collect(toSet());
    }

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        if (value == null) return false;
        LocalDate localDate = toLocalDate(value);
        return validDays.contains(localDate.getDayOfWeek());
    }

    protected abstract LocalDate toLocalDate(T value);

}
