package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.facade.TrainerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Controller
@RequestMapping("/")
public class HomepageController {

    @Autowired
    private TrainerFacade trainerFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, Principal principal) {
        model.addAttribute("trainer", trainerFacade.findByEmail(principal.getName()));
        return "home";
    }

}
