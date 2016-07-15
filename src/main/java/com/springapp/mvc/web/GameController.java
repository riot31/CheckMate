package com.springapp.mvc.web;

import com.springapp.mvc.entity.Game;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.boots.Boots;
import com.springapp.mvc.service.enums.GameStatus;
import com.springapp.mvc.service.form.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.security.Principal;
import java.util.Map;

/**
 * Created by o.lutsevich on 7.2.16.
 */
@Controller
@RequestMapping("/game")
@PreAuthorize("isAuthenticated()")
public class GameController {
    @Autowired
    private GameService gameService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGame(GameForm form, Map<String, Object> map) {
        Game newGame = gameService.toEntity(form);
        gameService.saveOrUpdate(newGame);
        map.put("game", newGame);
        return "checkmate";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showGames(Map<String, Object> map) {
        map.put("gameList", gameService.find());
        return "gameList";
    }

    @RequestMapping(value = "/byUser", method = RequestMethod.GET)
    public String showGameUser(Map<String, Object> map, Principal principal) {
        map.put("gameList", gameService.byUsername(principal.getName()));
        return "gameUser";
    }

    @RequestMapping(value = "/take", method = RequestMethod.GET)
    public String take(String uuid, Principal principal) {
        Game game = gameService.find(uuid);
        game.setMember2(principal.getName());
        game.setStatus(GameStatus.START.getStatus());
        gameService.saveOrUpdate(game);
        return "redirect:/go?id" + uuid;
    }

    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public String goGame(String uuid, Map<String, Object> map) {
        Game game = gameService.find(uuid);
        if (game.getMember2().equals(Boots.SIMPLE_BOOT.getBootName())) {
            map.put("socketSuffix", Boots.SIMPLE_BOOT.getBootName());
        } else if (game.getMember2().equals(Boots.NEGAMAX.getBootName())) {
            map.put("socketSuffix", Boots.NEGAMAX.getBootName());
        }
        map.put("game", game);
        map.put("strokeList", gameService.getStrokes(game));
        return "checkmate";
    }
}
