package com.BookMyShow.app.repositories.inMemory;

import com.BookMyShow.app.models.User;
import com.BookMyShow.app.repositories.interfaces.UserRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
