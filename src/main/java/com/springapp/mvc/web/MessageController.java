package com.springapp.mvc.web;

import com.springapp.mvc.boots.HeadNegaMax;
import com.springapp.mvc.entity.Game;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.MessageService;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.boots.Boots;
import com.springapp.mvc.service.enums.GameStatus;
import com.springapp.mvc.service.enums.MessageType;
import com.springapp.mvc.service.form.MessageForm;
import com.springapp.mvc.boots.HeadSimpleBoot;
import com.springapp.mvc.boots.board.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by o.lutsevich on 6.2.16.
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private HeadSimpleBoot headSimpleBoot;

    @Autowired
    private HeadNegaMax headNegaMax;

    @MessageMapping("/room/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendMessage(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        return message;
    }

    @MessageMapping("/room/end/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendEnd(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        gameOver(gameUuid, message.getUsername());
        messageService.saveOrUpdate(messageService.toEntity(message));
        return message;
    }

    @MessageMapping("/room/Simple_Boot/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendSimpleStroke(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        Move stroke = headSimpleBoot.brain3(gameUuid);
        MessageForm messageBoot = new MessageForm(Boots.SIMPLE_BOOT.getBootName(), "я маленький гномик", gameUuid, MessageType.MESSAGE.getType());
        if (stroke != null) {
            messageBoot = new MessageForm(Boots.SIMPLE_BOOT.getBootName(), "" + stroke.getPredator().getCoordinate() + " " + stroke.getStroke(), gameUuid, MessageType.STROKE.getType());
            messageService.saveOrUpdate(messageService.toEntity(messageBoot));
        }
        return messageBoot;
    }


    @MessageMapping("/room/NegaMax/{gameUuid}")
    @SendTo("/topic/{gameUuid}")
    public MessageForm sendNegaMaxStroke(@DestinationVariable String gameUuid, MessageForm message) throws Exception {
        message.setGameUuid(gameUuid);
        messageService.saveOrUpdate(messageService.toEntity(message));
        Move stroke = headNegaMax.brain(gameUuid);
        MessageForm messageBoot = new MessageForm(Boots.NEGAMAX.getBootName(), "я маленький гномик", gameUuid, MessageType.MESSAGE.getType());
        if (stroke != null) {
            messageBoot = new MessageForm(Boots.NEGAMAX.getBootName(), "" + stroke.getPredator().getCoordinate() + " " + stroke.getStroke(), gameUuid, MessageType.STROKE.getType());
            messageService.saveOrUpdate(messageService.toEntity(messageBoot));
        }
        return messageBoot;
    }

    private void gameOver(String gameUuid, String userWin) {
        Game game = gameService.find(gameUuid);
        game.setStatus(GameStatus.OVER.getStatus());
        gameService.saveOrUpdate(game);

        User member1 = userService.findByUsername(game.getMember1());
        User member2 = userService.findByUsername(game.getMember2());
        if (member1.getUsername().equals(userWin)) {
            member1.gamesIncrement();
            member2.lossesIncrement();
            member2.gamesIncrement();
        } else {
            member2.gamesIncrement();
            member1.gamesIncrement();
            member1.lossesIncrement();
        }
        userService.saveOrUpdate(member1);
        userService.saveOrUpdate(member2);
    }
}
