package com.springapp.mvc.web;

import com.springapp.mvc.entity.Evaluation;
import com.springapp.mvc.entity.Offer;
import com.springapp.mvc.service.OfferService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

/**
 * Created by o.lutsevich on 4.7.16.
 */
@Controller
@RequestMapping("/offer")
public class OfferController {
    private static final int INCREMENT = 1;
    private static final int DECREMENT = -1;

    @Autowired
    private OfferService offerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Map<String, Object> map) {
        map.put("offers", offerService.find());
        return "offers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Offer offer, Principal principal) {
        offer.setUser(userService.findByUsername(principal.getName()));
        offerService.saveOrUpdate(offer);
        return "redirect:/offer/show";
    }

    @RequestMapping(value = "/increment", method = RequestMethod.GET)
    public String increment(Integer id, Principal principal) {
        if (principal != null) {
            Offer offer = offerService.find(id);
            Evaluation evaluation = new Evaluation(offer, userService.findByUsername(principal.getName()), INCREMENT);
            offer.getEvaluationList().add(evaluation);
            offerService.saveOrUpdate(offer);
        }
        return "redirect:/offer/show";
    }

    @RequestMapping(value = "/decrement", method = RequestMethod.GET)
    public String decrement(Integer id, Principal principal) {
        Offer offer = offerService.find(id);
        Evaluation evaluation = new Evaluation(offer, userService.findByUsername(principal.getName()), DECREMENT);
        offer.getEvaluationList().add(evaluation);
        offerService.saveOrUpdate(offer);
        return "redirect:/offer/show";
    }
}
