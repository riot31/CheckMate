package com.springapp.mvc.web;

import com.springapp.mvc.boots.Boots;
import com.springapp.mvc.entity.Game;
import com.springapp.mvc.service.GameService;
import com.springapp.mvc.service.enums.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by o.lutsevich on 8.7.16.
 */
@Controller
@RequestMapping("/boot")
public class BootController {
    private static final String BOOT_HEADLINE = "Игра с ботом";

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/simple_boot", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String createSimpleGame(Principal principal) {
        Game newGame = new Game(BOOT_HEADLINE, principal.getName(), Boots.SIMPLE_BOOT.getBootName(), GameStatus.START.getStatus());
        gameService.saveOrUpdate(newGame);
        return "redirect:/game/go?uuid=" + newGame.getUuid();
    }

    @RequestMapping(value = "/negaMax", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String createNegaMaxGame(Principal principal) {
        Game newGame = new Game(BOOT_HEADLINE, principal.getName(), Boots.NEGAMAX.getBootName(), GameStatus.START.getStatus());
        gameService.saveOrUpdate(newGame);
        return "redirect:/game/go?uuid=" + newGame.getUuid();
    }
}
