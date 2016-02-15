package com.springapp.mvc.service;

import com.springapp.mvc.dao.BaseDao;
import com.springapp.mvc.dao.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Service("baseServiceImpl")
@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> {
    @Autowired
    private BaseDao<T, ID> baseDao;

    public List<T> find() {
        return baseDao.find();
    }

    public T find(ID id) {
        return baseDao.find(id);
    }

    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    public void remove(T entity) {
        baseDao.remove(entity);
    }

    public List<T> findByCriteria(List<SearchCriteria> criterias) {
        List<T> result = new ArrayList<T>();
        for (SearchCriteria criteria : criterias) {
            result.add(baseDao.findByCriteria(criteria));
        }
        return result;
    }

    public T findByCriteria(SearchCriteria criteria) {
        return baseDao.findByCriteria(criteria);
    }

    public List<T> findAllByCriteria(SearchCriteria criteria) {
        return baseDao.findAllByCriteria(criteria);
    }
}
