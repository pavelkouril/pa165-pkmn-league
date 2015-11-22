/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Badge;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oldrich Faldik
 */
@Repository
public class BadgeDaoImpl implements BadgeDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Badge findById(int id) {
        return entityManager.find(Badge.class, id);
    }

    @Override
    public void save(Badge badge) {
        entityManager.persist(badge);
    }

    @Override
    public void delete(Badge badge) {
        entityManager.remove(badge);
    }

    @Override
    public List<Badge> findAll() {
        return entityManager.createQuery("select b from Badge b", Badge.class).getResultList();
    }

 
    
}

