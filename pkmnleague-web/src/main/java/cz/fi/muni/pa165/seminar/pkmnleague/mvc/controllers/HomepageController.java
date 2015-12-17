package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Controller
@RequestMapping("/home")
public class HomepageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        Trainer trainer = new Trainer("Foobar", "ahoj@ble.cz", "", new Date(1992, 10, 10));
        trainer.addPokemon(new Pokemon(trainer, 25, "Pikachu", PokemonType.ELECTRIC, 88));
        trainer.addPokemon(new Pokemon(trainer, 131, "Lapras", PokemonType.WATER, PokemonType.ICE, 80));
        trainer.addPokemon(new Pokemon(trainer, 143, "Snorlax", PokemonType.NORMAL, 88));
        trainer.addPokemon(new Pokemon(trainer, 3, "Venusaur", PokemonType.GRASS, PokemonType.POISON, 84));
        trainer.addPokemon(new Pokemon(trainer, 6, "Charziard", PokemonType.FIRE, PokemonType.FLYING, 84));
        trainer.addPokemon(new Pokemon(trainer, 9, "Blastoise", PokemonType.WATER, 84));
        model.addAttribute("trainer", trainer);
        return "home";
    }

}
