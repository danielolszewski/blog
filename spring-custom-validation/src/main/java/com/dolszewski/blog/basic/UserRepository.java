package com.dolszewski.blog.basic;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
class UserRepository {

    private List<User> registeredUsers = new LinkedList<>();

    void save(User user) {
        registeredUsers.add(user);
    }

    Optional<User> findByLogin(String login) {
        return registeredUsers.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }

}
