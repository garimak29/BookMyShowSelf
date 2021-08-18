package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.Customer;
import com.BookMyShow.app.models.User;

import java.util.Optional;

public interface CustomerRepository extends AbstractRepository {

    Optional<Customer> findByUser(User user);

    void findByEmail();
}
