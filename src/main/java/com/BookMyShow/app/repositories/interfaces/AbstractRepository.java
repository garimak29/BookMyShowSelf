package com.BookMyShow.app.repositories;

import java.util.List;

public interface AbstractRepository <Entity , IdType> {

    // create / update
    void save(Entity entity);
    // read
    Entity findById(IdType id);
    // delete
    void delete(Entity entity);

    //list
    List<Entity> findAll();

}
