package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Offer;
import org.hibernate.AssertionFailure;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

/**
 * Created by o.lutsevich on 4.7.16.
 */
@Repository("offerDaoImpl")
public class OfferDaoImpl extends BaseDaoImpl<Offer, Integer> implements OfferDao {
    @Override
    public void saveOrUpdate(Offer entity) {
        try {
            super.saveOrUpdate(entity);
        } catch (ConstraintViolationException e) {
            super.getSession().clear();
        }
    }
}
