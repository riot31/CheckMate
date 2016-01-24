package com.springapp.mvc.dao;

import com.springapp.mvc.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
}
