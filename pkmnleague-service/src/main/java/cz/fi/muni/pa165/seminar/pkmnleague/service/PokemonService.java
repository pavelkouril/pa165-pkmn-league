package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;

import java.util.List;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface PokemonService {
    Pokemon findById(int id);
    List<Pokemon> findAll();
    void delete(Pokemon pokemon);
    void create(Pokemon pokemon);

    void levelUpPokemon(Pokemon pokemon);
}
