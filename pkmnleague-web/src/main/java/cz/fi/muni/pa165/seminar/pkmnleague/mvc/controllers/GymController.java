package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.BadgeDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.GymFacade;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.TrainerFacade;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dhanak @domhanak on 12/18/15.
 */
@Controller
@RequestMapping("/gym")
public class GymController {

    final static Logger log = LoggerFactory.getLogger(PokemonController.class);

    @ModelAttribute("gym")
    public GymCreateDTO getGym() {
        return new GymCreateDTO();
    }

    @Autowired
    private GymFacade gymFacade;

    @Autowired
    private TrainerFacade trainerFacade;

    /**
     * Lists all gyms.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String gyms(Model model, Principal principal) {
        log.info("Gyms = {}", gymFacade.getAllGyms());
        TrainerDTO trainer = trainerFacade.findByEmail(principal.getName());
        Set<GymDTO> beatenGyms = trainer.getBadges().stream().map(BadgeDTO::getGym).collect(Collectors.toSet());
        model.addAttribute("beatenGyms", beatenGyms);
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
    public String create(Model model, Principal principal) {
        log.debug("Create new gym");
        model.addAttribute("createGym", new GymCreateDTO());
        return "gym/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("gym") GymCreateDTO gym, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Principal principal, HttpSession session) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/gym/create").build();
        }
        gym.setLeader(trainerFacade.findByEmail(principal.getName()));
        gymFacade.createGym(gym);

        session.invalidate();
        return "redirect:/login?role";

    }
}
