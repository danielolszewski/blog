package com.dolszewski.blog.multitype;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DaysOfWeekDateValidator extends DaysOfWeekValidator<Date> {

    @Override
    protected LocalDate toLocalDate(Date value) {
        return value.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
