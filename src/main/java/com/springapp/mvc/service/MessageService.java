package com.springapp.mvc.service;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.service.form.MessageForm;

import java.util.List;

/**
 * Created by o.lutsevich on 9.2.16.
 */
public interface MessageService extends BaseService<Message, Integer> {
    Message toEntity(MessageForm form);

    MessageForm toForm(Message message);
}
