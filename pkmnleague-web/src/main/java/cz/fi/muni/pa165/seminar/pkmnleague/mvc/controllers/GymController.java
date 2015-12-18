package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.PokemonCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.GymFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Locale;

/**
 * @author dhanak @domhanak on 12/18/15.
 */
@Controller
@RequestMapping("/gym")
public class GymController {

    final static Logger log = LoggerFactory.getLogger(PokemonController.class);

    @ModelAttribute("gym")
    public GymCreateDTO getGym(){
        return new GymCreateDTO();
    }

    @Autowired
    GymFacade gymFacade;

    /**
     * Lists all gyms.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String gyms(Model model) {
        log.info("Gyms = {}", gymFacade.getAllGyms());
        model.addAttribute("gyms", gymFacade.getAllGyms());
        return "gym/list";
    }

    /**
     * Runs a new page with a form for new gym.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("Create new gym");
        model.addAttribute("createGym", new PokemonCreateDTO());
        return "gym/create";
    }

    /**
     * Creates new Gym.
     *
     * @param gym
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("gym") GymCreateDTO gym, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {


        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/gym/create").build();
        }
        gymFacade.createGym(gym);

        redirectAttributes.addFlashAttribute("alert_success", "Gym was successfully created.");

        return "redirect:" + uriBuilder.path("/gym/list").build();

    }
}
