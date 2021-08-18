package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.Role;

import java.util.Optional;

public interface RoleRepository extends AbstractRepository {
    Optional<Role> getRoleByName(String customer);
}
