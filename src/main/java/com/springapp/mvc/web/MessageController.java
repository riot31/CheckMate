package com.springapp.mvc.web;

import com.springapp.mvc.boot.HeadBoot;
import com.springapp.mvc.boot.HeadSimpleBoot;
import com.springapp.mvc.boot.QueueStroke;
import com.springapp.mvc.boot.board.Move;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.MessageService;
import com.springapp.mvc.service.enums.MessageType;
import com.springapp.mvc.service.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by o.lutsevich on 6.2.16.
 */
@Controller
public class MessageController {
    private final static String BLACK_COLOR = "black";

    @Autowired
    private MessageService messageService;

    @Autowired
    private GameService gameService;

    @Resource(name = "bootServices")
    private Map<String, HeadBoot> bootServices;


    @MessageMapping("/room/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendMessage(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        return message;
    }

    @MessageMapping("/room/performance/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendPerformance(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        return message;
    }

    @MessageMapping("/room/end/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendEnd(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        gameService.gameOver(gameUuid, message.getUsername());
        messageService.saveOrUpdate(messageService.toEntity(message));
        return message;
    }

    @MessageMapping("/room/{bootName}/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendBootStroke(@DestinationVariable String bootName, @DestinationVariable String gameUuid, MessageForm message) {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        Move stroke = bootServices.get(bootName).brain(gameUuid);
        MessageForm messageBoot = new MessageForm(bootName, "я маленький гномик", gameUuid, MessageType.MESSAGE.getType());
        if (stroke != null) {
            messageBoot = new MessageForm(bootName, "" + stroke.getPredator().getPosition() + " " + stroke.getStroke(), gameUuid, MessageType.STROKE.getType());
            messageService.saveOrUpdate(messageService.toEntity(messageBoot));
        }
        return messageBoot;
    }

    @MessageMapping("/room/scramble/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendResponse(@DestinationVariable String gameUuid, QueueStroke queue) {
        Move stroke = bootServices.get(queue.getBootName()).brain(gameUuid, queue.isBlack());
        MessageForm messageBoot = new MessageForm(queue.getBootName(), "" + stroke.getPredator().getPosition() + " " + stroke.getStroke(), gameUuid, MessageType.STROKE.getType());
        messageService.saveOrUpdate(messageService.toEntity(messageBoot));
        return messageBoot;
    }
}
