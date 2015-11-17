package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * Implementation of GymDao interface.
 * 
 * @author Zuzana Goldmannova
 */
public class GymDaoImpl implements GymDao{
     @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Gym findById(int id) {
        return entityManager.find(Gym.class, id);
    }

    @Override
    public void save(Gym gym) {
        entityManager.persist(gym);
    }

    @Override
    public void delete(Gym gym) {
        entityManager.remove(gym);
    }

    @Override
    public List<Gym> findAll() {
        return entityManager.createQuery("select g from Gym g", Gym.class).getResultList();
    }
    
}
