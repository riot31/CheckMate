package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Message;
import org.springframework.stereotype.Repository;

/**
 * Created by o.lutsevich on 9.2.16.
 */
@Repository("messageDaoImpl")
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements MessageDao {
}
