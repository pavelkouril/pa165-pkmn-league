package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.dao.PokemonDao;
import cz.fi.muni.pa165.seminar.pkmnleague.dao.TrainerDao;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.service.config.ServiceConfiguration;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * @author dhanak @domhanak on 11/26/15.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TrainerServiceTest {

    @Mock
    private TrainerDao trainerDao;


    @Autowired
    @InjectMocks
    private TrainerService trainerService = new TrainerServiceImpl();

    @Mock
    private PokemonService pokemonService;

    private Trainer trainer;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        trainer = new Trainer();
        trainer.setName("Tester");

        trainerService.create(trainer);
        new ArrayList<>(createPokemonTeam().values()).forEach(pokemonService::create);
    }

    @Test
    public void testFindAll() {
        when(trainerDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(trainerService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(trainerDao.findById(1)).thenReturn(createTrainersTeam().get("Ash"));
        assertEquals(trainerService.findById(1), new Trainer("Ash", "Ketchup", Date.from(Instant.EPOCH)));
    }

    @Test
    public void testFindTrainersPokemons() throws Exception {
        when(trainerDao.findById(1)).thenReturn(trainer);
        when(pokemonService.findAll()).thenReturn(new ArrayList<>(createPokemonTeam().values()));
        assertEquals(trainerService.findById(1), trainer);

        assertEquals(trainerService.findTrainersPokemons(trainerService.findById(1)).size(),0);
    }

    private Map<String, Trainer> createTrainersTeam() {
        Map<String, Trainer> team = new HashMap<>();
        team.put("Ash", new Trainer("Ash", "Ketchup", Date.from(Instant.EPOCH)));
        team.put("Brock", new Trainer("Brock", "Rocker", new Date()));
        return team;
    }

    private Map<String, Pokemon> createPokemonTeam() {
        Map<String, Pokemon> team = new HashMap<>();
        team.put("pikachu", new Pokemon(trainer, 25, "Pikachu", PokemonType.ELECTRIC, 88));
        team.put("lapras", new Pokemon(trainer, 131, "Lapras", PokemonType.WATER, PokemonType.ICE, 80));
        team.put("snorlax", new Pokemon(trainer, 143, "Snorlax", PokemonType.NORMAL, 88));
        team.put("venusaur", new Pokemon(trainer, 3, "Venusaur", PokemonType.GRASS, PokemonType.POISON, 84));
        team.put("charizard", new Pokemon(trainer, 6, "Charziard", PokemonType.FIRE, PokemonType.FLYING, 84));
        team.put("blastoise", new Pokemon(trainer, 9, "Blastoise", PokemonType.WATER, 84));
        return team;
    }
}
