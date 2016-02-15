package com.springapp.mvc.service.converter;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 9.2.16.
 */
@Service("messageConverter")
public class MessageConverter extends AbstractConverter<Message, MessageForm> {
    @Autowired
    private GameService gameService;

    @Override
    public Message toEntity(MessageForm form) {
        Message message = super.toEntity(form);
        message.setGame(gameService.find(form.getGameUuid()));
        return message;
    }

    @Override
    public MessageForm toForm(Message message) {
        MessageForm form = super.toForm(message);
        form.setGameUuid(message.getGame().getUuid());
        return form;
    }
}
