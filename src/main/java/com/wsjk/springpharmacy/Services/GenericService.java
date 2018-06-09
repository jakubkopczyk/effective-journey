package com.wsjk.springpharmacy.Services;

import java.util.List;

public interface GenericService<T> {
    T findOne(int id);

    List<T> findAll();

    void create(final T entity);

    void saveOrUpdate(final T entity);

    void delete(final T entity);

    void deleteById(final Integer id);
}
