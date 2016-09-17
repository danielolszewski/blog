package com.dolszewski.blog.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;

    @Test
    public void shouldValidateDuplicatedLogin() throws Exception {
        // given
        String login = "daniel";
        User predefinedUser = new User(login, "pass".toCharArray());
        userRepository.save(predefinedUser);
        // when
        User newUser = new User(login, "asd".toCharArray());
        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        // then
        assertEquals(1, violations.size());
    }

}