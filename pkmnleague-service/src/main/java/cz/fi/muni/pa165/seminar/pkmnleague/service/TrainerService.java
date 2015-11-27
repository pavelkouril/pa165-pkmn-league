package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Trainer} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface TrainerService {
    void create(Trainer trainer);
    Trainer findById(int id);
    List<Trainer> findAll();
    void delete(Trainer trainer);

    /**
     * Finds out if the given trainer is GymLeader.
     *
     * @param trainer
     * @return
     */
    boolean isGymLeader(Trainer trainer);

    /**
     *
     * @param trainer
     * @return
     */
    List<Pokemon> findTrainersPokemons(Trainer trainer);

}