package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Controller
@RequestMapping("/home")
public class HomepageController {
    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return "home";
    }
}
