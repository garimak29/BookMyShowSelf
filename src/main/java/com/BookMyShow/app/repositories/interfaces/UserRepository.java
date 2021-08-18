package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Long>{
    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String phone);

    Optional<User> findByEmail(String email);
}
