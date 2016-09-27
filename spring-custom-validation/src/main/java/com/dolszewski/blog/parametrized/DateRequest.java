package com.dolszewski.blog.parametrized;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.DayOfWeek.*;

public class DateRequest {

    @DaysOfWeek(days = {SATURDAY, SUNDAY})
    private LocalDate weekendDay;
    @DaysOfWeek(days = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY})
    private LocalDate workingDay;

    public DateRequest(LocalDate weekendDay, LocalDate workingDay) {
        Objects.requireNonNull(weekendDay);
        Objects.requireNonNull(workingDay);
        this.weekendDay = weekendDay;
        this.workingDay = workingDay;
    }

    public LocalDate getWeekendDay() {
        return weekendDay;
    }

    public LocalDate getWorkingDay() {
        return workingDay;
    }

}
