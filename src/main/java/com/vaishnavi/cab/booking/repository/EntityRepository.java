package com.vaishnavi.cab.booking.repository;

import java.util.List;

public interface EntityRepository<T> {
    void add(T entity);
    List<T> getAll();
    void update(T entity);
    void delete(int id);
}

