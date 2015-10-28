/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dao;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import java.util.List;

/**
 *
 * Data Access Object providing access to database operations for Gym entity
 * 
 * @author Oldrich Faldik
 */
public interface GymDao {
    /**
     * Finds and returns Gym by given ID (primary key)
     */
    public Gym findById(int id);
    
    /**
     * Saves Gym entity to database, can either update existing Gym or save new one
     */
    public void save(Gym gym);
    
    /**
     * Deletes given Gym entity from database
     */
    public void delete(Gym gym);

    /**
     * Returns all Gym entitys from database
     */
    public List<Gym> findAll();
    
}
