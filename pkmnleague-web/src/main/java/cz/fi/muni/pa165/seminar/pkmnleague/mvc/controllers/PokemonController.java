package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.PokemonCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.PokemonDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.PokemonFacade;
import cz.fi.muni.pa165.seminar.pkmnleague.mvc.exceptions.UnexisitngReourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/pokemon")
public class PokemonController {

    final static Logger log = LoggerFactory.getLogger(PokemonController.class);

    @ModelAttribute("pokemon")
    public PokemonCreateDTO getPokemon(){
        return new PokemonCreateDTO();
    }

    @Autowired
    PokemonFacade pokemonFacade;

    /**
     * Lists all pokemon.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String pokemons(Model model) {
        log.info("Pokemons = {}", pokemonFacade.getAllPokemons());
        model.addAttribute("pokemons", pokemonFacade.getAllPokemons());
        return "pokemon/list";
    }

    /**
     * Runs a new page with a form for new pokemons.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("Create new pokemon");
        model.addAttribute("createPokemon", new PokemonCreateDTO());
        return "pokemon/create";
    }

    /**
     * Creates new Pokemon.
     *
     * @param pokemon
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("pokemon") PokemonCreateDTO pokemon, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {


        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/room/create").build();
        }
        pokemonFacade.createPokemon(pokemon);

        redirectAttributes.addFlashAttribute("alert_success", "Pokemon was successfully created.");

        return "redirect:" + uriBuilder.path("/pokemon/list").build();

    }
}
