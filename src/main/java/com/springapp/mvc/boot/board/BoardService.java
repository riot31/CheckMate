package com.springapp.mvc.boot.board;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.enums.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o.lutsevich on 6.7.16.
 */
@Service("boardService")
public class BoardService {
    private Board board = null;

    @Autowired
    private GameService gameService;

    public Board getBoard(String gameUuid) {
        board = new Board();
        for (Message message : filterStroke(gameService.find(gameUuid).getMessageList())) {
            makeMove(message);
        }
        return board;
    }

    private List<Message> filterStroke(List<Message> messageList) {
        List<Message> strokes = new ArrayList<Message>();
        for (Message message : messageList) {
            if (message.getType().equals(MessageType.STROKE.getType())) {
                strokes.add(message);
            }
        }
        return strokes;
    }

    private void makeMove(Message message) {
        String[] stroke = message.getMessage().split(" ");
        board.takeItem(Integer.parseInt(stroke[0]), Integer.parseInt(stroke[1]));
    }
}
