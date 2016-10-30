package com.dolszewski.blog.multitype;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import static java.time.DayOfWeek.*;

public class DateRequest {

    @DaysOfWeek(days = {SATURDAY, SUNDAY})
    private Date weekendDay;
    @DaysOfWeek(days = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY})
    private LocalDate workingDay;

    public DateRequest(Date weekendDay, LocalDate workingDay) {
        Objects.requireNonNull(weekendDay);
        Objects.requireNonNull(workingDay);
        this.weekendDay = weekendDay;
        this.workingDay = workingDay;
    }

    public Date getWeekendDay() {
        return weekendDay;
    }

    public LocalDate getWorkingDay() {
        return workingDay;
    }

}
