package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.utils.EmbeddedDerbyDatabase;
import java.sql.Date;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 *
 * @author Zuzana Goldmannova
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TrainerDaoTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private TrainerDao trainerDao;
    
    @Test
    public void testSave() {
        
        Trainer trainer = new Trainer();
        trainer.setName("Brok");
        trainer.setSurname("Stone");
        trainer.setDateOfBirth(new Date(0));

        trainerDao.save(trainer);

        Trainer result = trainerDao.findById(trainer.getId());
        Assert.assertEquals(trainer, result);
    }
    
    @Test
    public void testDelete() {
       Trainer trainer = new Trainer();
       trainer.setName("Brok");
       trainer.setSurname("Stone");
       trainer.setDateOfBirth(new Date(0));       

       trainerDao.save(trainer);
       trainerDao.delete(trainer);

       Assert.assertEquals(0, trainerDao.findAll().size());
    }
    
    @Test
    public void testFindAll() {
       Trainer trainer = new Trainer();
       trainer.setName("Brok");
       trainer.setSurname("Stone");
       trainer.setDateOfBirth(new Date(0)); 

       trainerDao.save(trainer);

       Assert.assertEquals(1, trainerDao.findAll().size());
    }
}
