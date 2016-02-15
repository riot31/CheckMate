package com.springapp.mvc.web;

import com.springapp.mvc.entity.Game;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.form.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Map;

/**
 * Created by o.lutsevich on 7.2.16.
 */
@Controller
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGame(GameForm form, Map<String, Object> map) {
        Game newGame = gameService.toEntity(form);
        gameService.saveOrUpdate(newGame);
        map.put("gameUuid", newGame.getUuid());
        return "checkmate";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showGames(Map<String, Object> map) {
        map.put("gameList", gameService.find());
        return "gameList";
    }

    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public String goGame(String uuid, Map<String, Object> map) {
        Game game = gameService.find(uuid);
        map.put("game", game);
        map.put("strokeList", gameService.getStrokes(game));
        return "checkmate";
    }
}
