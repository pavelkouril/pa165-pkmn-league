package cz.fi.muni.pa165.seminar.pkmnleague.mvc.data;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.service.GymService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.PokemonService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Component
@Transactional
public class SampleData {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private GymService gymService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void loadData() {
        Trainer trainerRed = trainer("Red", "red@example.com", "heslo", new Date(0));
        Trainer trainerGreen = trainer("Green", "green@example.com", "heslo", new Date(0));

        Pokemon rPikachu = pokemon(trainerRed, 25, "Pikachu", PokemonType.ELECTRIC, 88);
        Pokemon rLapras = pokemon(trainerRed, 131, "Lapras", PokemonType.WATER, PokemonType.ICE, 80);
        Pokemon rSnorlax = pokemon(trainerRed, 143, "Snorlax", PokemonType.NORMAL, 88);
        Pokemon rVenusaur = pokemon(trainerRed, 3, "Venusaur", PokemonType.GRASS, PokemonType.POISON, 84);
        Pokemon rCharizard = pokemon(trainerRed, 6, "Charziard", PokemonType.FIRE, PokemonType.FLYING, 84);
        Pokemon rBlastoise = pokemon(trainerRed, 9, "Blastoise", PokemonType.WATER, 84);

        Pokemon scizor = pokemon(trainerGreen, 212, "Scizor", PokemonType.BUG, PokemonType.STEEL, 55);

        Gym viridianGym = gym("Viridian City", PokemonType.GROUND, trainerGreen);
    }

    private Trainer trainer(String fullName, String email, String password, Date dateOfBirth) {
        Trainer t = new Trainer(fullName, email, passwordEncoder.encode(password), dateOfBirth);
        trainerService.create(t);
        return t;
    }

    private Pokemon pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, int level) {
        Pokemon p = new Pokemon(trainer, speciesId, speciesName, primaryType, level);
        pokemonService.create(p);
        return p;
    }

    private Pokemon pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, PokemonType secondaryType, int level) {
        Pokemon p = new Pokemon(trainer, speciesId, speciesName, primaryType, secondaryType, level);
        pokemonService.create(p);
        return p;
    }

    private Gym gym(String city, PokemonType type, Trainer trainer) {
        Gym g = new Gym(city, type, trainer);
        gymService.create(g);
        return g;
    }

}
