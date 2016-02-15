package com.springapp.mvc.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public interface BaseDao<T, ID extends Serializable> {
    List<T> find();

    T find(ID id);

    void saveOrUpdate(T entity);

    void remove(T entity);

    T findByCriteria(SearchCriteria criteria);

    List<T> findAllByCriteria(SearchCriteria criteria);
}
