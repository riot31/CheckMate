package com.springapp.mvc.web;

import com.springapp.mvc.boots.Boots;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.service.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class NavigationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", MessageUtils.getMessage("message.hello"));
        return "index";
    }

    @RequestMapping(value = "/regulations", method = RequestMethod.GET)
    public String showRegulations() {
        return "regulations";
    }

    @RequestMapping(value = "/boots", method = RequestMethod.GET)
    public String showBoots(Map<String, Object> map) {
        map.put("boots", Boots.values());
        return "boots";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics(Map<String, Object> map) {
        List<User> userList = userService.find();
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return (user.getGames() - user.getLosses()) < (t1.getGames() - t1.getLosses()) ? 1 : -1;
            }
        });
        map.put("userList", userList);
        return "statistics";
    }
}