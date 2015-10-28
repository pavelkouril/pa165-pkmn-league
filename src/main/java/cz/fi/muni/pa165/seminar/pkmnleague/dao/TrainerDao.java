package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;

import java.util.List;

/**
 * Dao interface for Pokemon entity.
 *
 * @author dhanak @domhanak on 10/28/15.
 */
public interface TrainerDao {
    public Trainer findById(int id);

    public void create(Trainer trainer);

    public void delete(Trainer trainer);

    public List<Trainer> findAll();
}
