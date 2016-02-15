package com.springapp.mvc.service;

import com.springapp.mvc.entity.Game;
import com.springapp.mvc.entity.Message;
import com.springapp.mvc.service.form.GameForm;

import java.util.List;

/**
 * Created by o.lutsevich on 25.1.16.
 */
public interface GameService extends BaseService<Game, String> {
    Game toEntity(GameForm form);

    GameForm toForm(Game game);

    List<Message> getStrokes(Game game);

    List<Game> byUsername(String username);
}
