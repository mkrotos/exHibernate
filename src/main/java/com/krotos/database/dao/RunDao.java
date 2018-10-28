package com.krotos.database.dao;

import com.krotos.database.entity.Run;

import java.util.List;
import java.util.Optional;

public interface RunDao {

    void saveOrUpdate(Run run);
    List<Run> getAll();
    Optional<Run> findById(long id);
    void delete(Run run);
}
