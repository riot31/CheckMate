package com.springapp.mvc.web;

import com.springapp.mvc.service.MessageService;
import com.springapp.mvc.service.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by o.lutsevich on 6.2.16.
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/room/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendMessage(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        return message;
    }

}
