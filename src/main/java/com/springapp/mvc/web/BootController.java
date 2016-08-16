package com.springapp.mvc.web;

import com.springapp.mvc.entity.Game;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.enums.GameStatus;
import com.springapp.mvc.service.form.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

/**
 * Created by o.lutsevich on 8.7.16.
 */
@Controller
@RequestMapping("/boot")
@PreAuthorize("isAuthenticated()")
public class BootController {
    private static final String BOOT_HEADLINE = "Игра с ботом";
    private static final String SCRAMBLE = "СХВАТКА";

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/{bootName}", method = RequestMethod.GET)
    public String createBootGame(@PathVariable String bootName, Principal principal) {
        Game newGame = new Game(BOOT_HEADLINE, principal.getName(), bootName, GameStatus.START.getStatus());
        gameService.saveOrUpdate(newGame);
        return "redirect:/game/go?uuid=" + newGame.getUuid();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGame(GameForm form, Map<String, Object> map) {
        form.setHeadline(SCRAMBLE);
        Game newGame = gameService.toEntity(form);
        newGame.setStatus(GameStatus.START.getStatus());
        gameService.saveOrUpdate(newGame);
        map.put("game", newGame);
        return "scramble-boots";
    }
}
