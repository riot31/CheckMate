package com.springapp.mvc.service.converter;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.form.UserForm;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 2.2.16.
 */
@Service("userConverter")
public class UserConverter extends AbstractConverter<User, UserForm> {
}
