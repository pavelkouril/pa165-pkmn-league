/*package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

///**
// * Implementation of PokemonDao interface.
// *
// * @author dhanak @domhanak on 10/28/15.
 //
@Repository
@Transactional
public class PokemonDaoImpl implements PokemonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pokemon findById(int id) {
        return entityManager.find(Pokemon.class, id);
    }

    @Override
    public void create(Pokemon pokemon) {
        entityManager.persist(pokemon);
    }

    @Override
    public void delete(Pokemon pokemon) {
        entityManager.remove(pokemon);
    }

    @Override
    public List<Pokemon> findAll() {
        return entityManager.createQuery("select p from Pokemon p", Pokemon.class).getResultList();
    }
} */
