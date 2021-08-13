package com.BookMyShow.app.repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository <Entity , IdType> {

    // create / update
    void save(Entity entity);
    // read
    Optional<Entity> findById(IdType id);
    // delete
    void delete(Entity entity);

    //list
    List<Entity> findAll();

}
