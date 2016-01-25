/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymEditDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
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
        */
        public void createGym(GymCreateDTO g);
        
        /**
        * Edit existing Gym
        *
        * @param g GymEditDTO - information about Gym
        */
        public void editGym(GymEditDTO g);
        
        /**
        * Delete existing Gym
        *
        * @param gymId ID of Gym
        */
        public void deleteGym(int gymId);
        
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
        public GymDTO getGymWithId(int id);
        
        /**
        * Gets existing Gyms by Leader ID
        *
        * @param trainerId 
        * @return List of GymDTOs
        */
        public List<GymDTO> getGymsByLeader(int trainerId);
        
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
        * @param gymId 
        * 
        */
        public void changeCity(String newCity, int gymId);
        
        /**
        * Change Leader of existing Gym
        *
        * @param newLeader 
        * @param gymId 
        * 
        */
        public void changeLeader(TrainerDTO newLeader, int gymId);
}
