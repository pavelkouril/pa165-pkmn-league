/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.enums.PokemonType;
import java.util.List;

/**
 * An interface that defines a facade access to the Gym Service.
 * 
 * @author Oldrich Faldik
 */
public interface GymFacade {
    
        /**
        * Create new Gym
        *
        * @param g GymCreateDTO - information about new Gym
        * @return ID of new Gym.
        */
        public Long createGym(GymCreateDTO g);
        
        /**
        * Delete existing Gym
        *
        * @param gymId ID of Gym
        */
        public void deleteGym(Long gymId);
        
        /**
        * Gets all existing Gyms
        * @return List of GymDTOs
        */
        public List<GymDTO> getAllGyms();
        
        /**
        * Gets existing Gym by ID
        *
        * @param id
        * @return GymDTO
        */
        public GymDTO getGymWithId(Long id);
        
        /**
        * Gets existing Gyms by Leader ID
        *
        * @param trainerId 
        * @return List of GymDTOs
        */
        public List<GymDTO> getGymsByLeader(Long trainerId);
        
        /**
        * Gets existing Gyms by PokemonType
        *
        * @param type 
        * @return List of GymDTOs
        */
        public List<GymDTO> getGymsByType(PokemonType type);
        
        /**
        * Change city of existing Gym
        *
        * @param newCity 
        * 
        */
        public void changeCity(String newCity);
        
        /**
        * Change Pokemon Type of existing Gym
        *
        * @param newType 
        * 
        */
        public void changeType(PokemonType newType);
        
        /**
        * Change Leader of existing Gym
        *
        * @param newLeader 
        * 
        */
        public void changeLeader(TrainerDTO newLeader);
}
