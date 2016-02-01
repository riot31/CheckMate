package com.springapp.mvc.service;

import com.springapp.mvc.dao.SearchCriteria;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.converter.UserConverter;
import com.springapp.mvc.service.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
    private static final String USERNAME_COLUMN = "username";
    private static final String EMAIL_COLUMN = "email";

    @Autowired
    private UserConverter converter;

    public User findByUsername(String username) {
        return super.findByCriteria(new SearchCriteria(USERNAME_COLUMN, username));
    }

    public User findByEmail(String email) {
        return super.findByCriteria(new SearchCriteria(EMAIL_COLUMN, email));
    }

    public User toUser(UserForm form) {
        return converter.toEntity(form);
    }

    public UserForm toForm(User user) {
        return converter.toDto(user);
    }
}
