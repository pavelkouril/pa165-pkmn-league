package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.dao.PokemonDao;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Service
public class PokemonServiceImpl implements PokemonService {
    @Inject
    private PokemonDao pokemonDao;

    @Override
    public Pokemon findById(int id) {
        return pokemonDao.findById(id);
    }

    @Override
    public List<Pokemon> findAll() {
        return pokemonDao.findAll();
    }

    @Override
    public void delete(Pokemon pokemon) {
        pokemonDao.delete(pokemon);
    }

    @Override
    public void create(Pokemon pokemon) {
        pokemonDao.save(pokemon);
    }
}
