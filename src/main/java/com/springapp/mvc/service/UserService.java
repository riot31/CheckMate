package com.springapp.mvc.service;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.form.UserForm;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public interface UserService extends BaseService<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);

    User toUser(UserForm form);

    UserForm toForm(User user);
}
