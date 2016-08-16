package com.springapp.mvc.web;


import com.springapp.mvc.entity.User;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.service.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by o.lutsevich on 1.2.16.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(UserForm form) {
        userService.saveOrUpdate(userService.toUser(form));
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/rivals", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getRivals(Principal principal) {
        List<String> result = new ArrayList<String>();
        List<User> users = userService.find();
        users.remove(userService.findByUsername(principal.getName()));
        for (User user : users) {
            result.add(user.getUsername());
        }
        return result;
    }

    @RequestMapping(value = "/user/statistics", method = RequestMethod.GET)
    public String showStatistics(Principal principal, Map<String, Object> map) {
        map.put("user", userService.findByUsername(principal.getName()));
        return "user";
    }
}
