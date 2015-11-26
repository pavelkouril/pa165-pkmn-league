package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.dao.TrainerDao;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.exceptions.PokemonLeagueServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link TrainerService}.
 * This class is part of the service module of the application
 * that provides the implementation of the business logic.
 * @author dhanak @domhanak on 11/26/15.
 */
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerDao trainerDao;

    @Autowired
    PokemonService pokemonService;


    @Override
    public void create(Trainer trainer) {
        trainerDao.save(trainer);
    }

    @Override
    public Trainer findById(int id) {
        return trainerDao.findById(id);
    }

    @Override
    public List<Trainer> findAll() {
        return trainerDao.findAll();
    }

    @Override
    public void delete(Trainer trainer) {
        trainerDao.delete(trainer);
    }

    @Override
    public boolean isGymLeader(Trainer trainer) {
        return findById(trainer.getId()).isGymLeader();
    }

    @Override
    public List<Pokemon> findTrainersPokemons(Trainer trainer) {
        if (trainer == null) {
            throw new PokemonLeagueServiceException("Can't find Pokemons for Trainer that is null");
        }

        Trainer trainer1 = findById(trainer.getId());
        List<Pokemon> pokemons = pokemonService.findAll();

        List<Pokemon> result = new ArrayList<>();
        for (Pokemon p : pokemons) {
            if (p.getTrainer().equals(trainer1)) {
                result.add(p);
            }
        }

        return result;
    }
}
