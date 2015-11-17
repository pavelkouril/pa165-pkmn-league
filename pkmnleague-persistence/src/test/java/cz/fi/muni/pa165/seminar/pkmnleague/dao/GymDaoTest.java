package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Pokemon;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.utils.EmbeddedDerbyDatabase;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author dhanak @domhanak on 10/29/15.
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class GymDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GymDao gymDao;

    private Gym testGym;
    private Gym deleteGym;
    private Pokemon testPokemon;
    private Trainer testTrainer;

    @BeforeMethod
    public void setUp() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(2222);

        testTrainer = new Trainer();
        testTrainer.setName("TestTrainer");
        testTrainer.setSurname("TestTrainerSurname");
        testTrainer.setDateOfBirth(date);

        testPokemon = new Pokemon(testTrainer, 1, "meno", PokemonType.BUG, 0);

        testGym = new Gym("Name", PokemonType.DARK, testTrainer);
        deleteGym = new Gym("Delete", PokemonType.DARK, testTrainer);
        gymDao.save(deleteGym);
    }

    @Test
    public void testCreate() {
        gymDao.save(testGym);

        Gym result = gymDao.findById(testGym.getId());
        Assert.assertEquals(testGym, result);
    }

    @Test
    public void testDelete() throws Exception {
        Gym result = gymDao.findById(deleteGym.getId());
        Assert.assertNotNull(result);
        
        gymDao.delete(deleteGym);

        Gym nullresult = gymDao.findById(deleteGym.getId());
        Assert.assertNull(nullresult);
    }

    @Test
    public void testFindGymById() throws Exception {
        gymDao.save(testGym);

        int id = testGym.getId();

        Gym result = gymDao.findById(id);
        Assert.assertEquals(result, testGym);
    }

    @Test
    public void testFindAllGyms() throws Exception {
        List<Gym> gymList = gymDao.findAll();
        Assert.assertEquals(gymList.size(), 1);
    }

}
