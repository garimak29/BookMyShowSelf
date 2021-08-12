package com.BookMyShow.app.repositories;

import com.BookMyShow.app.models.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Long>{
    Optional<User> findByUsername(String username);

}
