package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;

import java.util.List;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface TrainerService {
    Trainer findById(int id);
    List<Trainer> findAll();
    void delete(Trainer trainer);
}
