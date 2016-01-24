/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Badge;
import cz.fi.muni.pa165.seminar.pkmnleague.utils.DaoLayerException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
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
        try {
            return entityManager.find(Badge.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public void save(Badge badge) {
        if (findById(badge.getId()) != null) {
           try {
               entityManager.merge(badge);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(badge);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Badge badge) {
        try {
            entityManager.remove(findById(badge.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public List<Badge> findAll() {
        try {
            return entityManager.createQuery("select b from Badge b", Badge.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

 
    
}

