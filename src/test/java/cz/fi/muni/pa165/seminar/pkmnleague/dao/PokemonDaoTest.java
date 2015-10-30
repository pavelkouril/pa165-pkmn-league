/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.dao.PokemonDao;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.utils.EmbeddedDerbyDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Oldrich Faldik
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PokemonDaoTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private PokemonDao pokemonDao;
    
    private Pokemon testPokemon;
    private Trainer testTrainer;
    private Pokemon deletePokemon;
    
    @BeforeMethod
    public void setUp(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.sql.Date date = new java.sql.Date(2020);
        
        this.testTrainer=new Trainer();
        testTrainer.setName("TestTrainer");
        testTrainer.setSurname("TestTrainerSurname");
        testTrainer.setDateOfBirth(date);
        
        testPokemon = new Pokemon(testTrainer, 1, "testPokemon", PokemonType.BUG, 0);
        
        deletePokemon = new Pokemon(testTrainer, 1, "deletePokemon", PokemonType.BUG, 0);
        //this.testPokemon=new Pokemon();
    
    
    }
    
    
    @Test
    public void testSave() {
        
        pokemonDao.save(testPokemon);

        Pokemon result = pokemonDao.findById(testPokemon.getId());
        Assert.assertEquals(testPokemon, result);
    }
    
    @Test
    public void testFindById() {
        
        Pokemon result = pokemonDao.findById(testPokemon.getId());
        Assert.assertEquals(result, testPokemon);
    }
    
    @Test
    public void testDelete() {
        Pokemon result = pokemonDao.findById(deletePokemon.getId());
        Assert.assertNotNull(result);
        
        pokemonDao.delete(deletePokemon);

        Pokemon nullresult = pokemonDao.findById(deletePokemon.getId());
        Assert.assertNull(nullresult);
    }
    
    @Test
    public void testFindAll() {
        List<Pokemon> pokemonList = pokemonDao.findAll();
        Assert.assertEquals(pokemonList.size(), 1);
    }
    
    @Test
    public void testCreateNull() throws Exception {
        Pokemon pokemon = null;
        try {
            pokemonDao.save(pokemon);
        } catch (NullPointerException ex) {
            // ok, expected
        }
        Assert.fail("No NPE thrown when creating with null");
    }

    @Test
    public void testDeleteNull() throws Exception {
        Pokemon pokemon = null;
        try {
            pokemonDao.delete(pokemon);
        } catch (NullPointerException ex) {
            // ok, expected
        }
        Assert.fail("No NPE thrown when creating with null");
    }
    
}
