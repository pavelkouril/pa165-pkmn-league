package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Badge;
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
public class BadgeDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BadgeDao badgeDao;

    @Test
    public void testSave() {
        Trainer leader = new Trainer();
        leader.setName("Misty");
        leader.setSurname("?");
        leader.setDateOfBirth(new Date(1996, 1, 2));
        Gym gym = new Gym("Cerulean", PokemonType.WATER, leader);

        Trainer t = new Trainer();
        t.setName("Foo");
        t.setSurname("Bar");
        t.setDateOfBirth(new Date(0));

        Badge badge = new Badge(t, gym);

        badgeDao.save(badge);

        Badge result = badgeDao.findById(badge.getId());
        Assert.assertEquals(badge, result);
    }

    @Test
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

        Badge badge = new Badge(t, gym);

        badgeDao.save(badge);
        badgeDao.delete(badge);

        Assert.assertEquals(0, badgeDao.findAll().size());
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

        Badge badge = new Badge(t, gym);

        badgeDao.save(badge);

        Assert.assertEquals(1, badgeDao.findAll().size());
    }
}