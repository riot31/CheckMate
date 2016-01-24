package com.springapp.mvc.service;

import com.springapp.mvc.dao.SearchCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public interface BaseService<T, ID extends Serializable> {
    List<T> find();

    T find(ID id);

    void saveOrUpdate(T entity);

    void remove(T entity);

    List<T> findByCriteria(List<SearchCriteria> criterias);

    T findByCriteria(SearchCriteria criteria);
}
