package com.springapp.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Repository("baseDaoImpl")
public abstract class BaseDaoImpl<T, ID extends Serializable> {
    private Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public BaseDaoImpl() {
        Type e = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) e;
        this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public T find(ID id) {
        return (T) getSession().get(entityClass, id);
    }

    public List<T> find() {
        return getSession().createCriteria(entityClass).list();
    }

    public synchronized void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public synchronized void remove(T entity) {
        getSession().delete(entity);
    }

    public T findByCriteria(SearchCriteria criteria) {
        List<T> temp = getSession().createCriteria(entityClass).add(Restrictions.eq(criteria.getNameColumn(), criteria.getValue())).list();
        return temp.isEmpty() ? null : temp.get(0);
    }

    public List<T> findAllByCriteria(SearchCriteria criteria) {
        return getSession().createCriteria(entityClass).add(Restrictions.eq(criteria.getNameColumn(), criteria.getValue())).list();
    }
}
