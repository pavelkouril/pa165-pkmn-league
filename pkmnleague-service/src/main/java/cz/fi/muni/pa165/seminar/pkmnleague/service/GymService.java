package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;

import java.util.List;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface GymService {
    Gym findById(int id);
    List<Gym> findAll();
    void delete(Gym gym);
}
