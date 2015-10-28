package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;

import java.util.List;

/**
 * Dao interface for Pokemon entity.
 *
 * @author dhanak @domhanak on 10/28/15.
 */
public interface PokemonDao {
    public Pokemon findById(int id);

    public void create(Pokemon pokemon);

    public void delete(Pokemon pokemon);

    public List<Pokemon> findAll();
}
