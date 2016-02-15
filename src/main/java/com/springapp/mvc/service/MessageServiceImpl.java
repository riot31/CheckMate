package com.springapp.mvc.service;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.service.converter.MessageConverter;
import com.springapp.mvc.service.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 9.2.16.
 */
@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message, Integer> implements MessageService {
    @Autowired
    private MessageConverter converter;

    public Message toEntity(MessageForm form) {
        return converter.toEntity(form);
    }

    public MessageForm toForm(Message message) {
        return converter.toForm(message);
    }
}
