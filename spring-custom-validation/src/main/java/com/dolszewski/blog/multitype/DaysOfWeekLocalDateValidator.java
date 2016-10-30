package com.dolszewski.blog.multitype;

import java.time.LocalDate;

public class DaysOfWeekLocalDateValidator extends DaysOfWeekValidator<LocalDate> {

    @Override
    protected LocalDate toLocalDate(LocalDate value) {
        return value;
    }

}
