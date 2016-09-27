package com.dolszewski.blog.parametrized;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DateRequestTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void shouldMarkAllDatesInvalid() throws Exception {
        // given
        DateRequest request = new DateRequest(LocalDate.of(2016, 9, 20), LocalDate.of(2016, 9, 18));
        // when
        Set<ConstraintViolation<DateRequest>> violations = validator.validate(request);
        // then
        assertEquals(2, violations.size());
    }

}