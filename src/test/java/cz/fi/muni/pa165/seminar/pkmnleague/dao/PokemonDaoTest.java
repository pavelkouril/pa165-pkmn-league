package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.utils.EmbeddedDerbyDatabase;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

/**
 * @author Pavel Kouřil
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PokemonDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PokemonDao pokemonDao;

    @Test
    public void testSave() {
        

        Trainer t = new Trainer();
        t.setName("Foo");
        t.setSurname("Bar");
        t.setDateOfBirth(new Date(0));

        Pokemon pokemon = new Pokemon(t,1,"testPokemon",PokemonType.BUG,0);

        pokemonDao.save(pokemon);

        Pokemon result = pokemonDao.findById(pokemon.getId());
        Assert.assertEquals(pokemon, result);
    }

    /*@Test
    public void testDelete() {
        Trainer leader = new Trainer();
        leader.setName("Misty");
        leader.setSurname("?");
        leader.setDateOfBirth(new Date(1996, 1, 2));
        Gym gym = new Gym("Cerulean", PokemonType.WATER, leader);

        Trainer t = new Trainer();
        t.setName("Foo");
        t.setSurname("Bar");
        t.setDateOfBirth(new Date(0));

        Pokemon pokemon = new Pokemon(t, gym);

        pokemonDao.save(pokemon);
        pokemonDao.delete(pokemon);

        Assert.assertEquals(0, pokemonDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Trainer leader = new Trainer();
        leader.setName("Misty");
        leader.setSurname("?");
        leader.setDateOfBirth(new Date(1996, 1, 2));
        Gym gym = new Gym("Cerulean", PokemonType.WATER, leader);

        Trainer t = new Trainer();
        t.setName("Foo");
        t.setSurname("Bar");
        t.setDateOfBirth(new Date(0));

        Pokemon pokemon = new Pokemon(t, gym);

        pokemonDao.save(pokemon);

        Assert.assertEquals(1, pokemonDao.findAll().size());
    }*/
}
