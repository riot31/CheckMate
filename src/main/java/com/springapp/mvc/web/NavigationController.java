package com.springapp.mvc.web;

import com.springapp.mvc.service.util.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NavigationController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", MessageUtils.getMessage("message.hello"));
		return "index";
	}
	@RequestMapping(value = "game", method = RequestMethod.GET)
	public String showGame() {
		return "checkmate";
	}
}