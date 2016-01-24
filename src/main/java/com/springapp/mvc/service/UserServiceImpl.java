package com.springapp.mvc.service;

import com.springapp.mvc.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
}
