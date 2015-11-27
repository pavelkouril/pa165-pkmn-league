/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.BadgeDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import java.util.Date;
import java.util.List;

/**
 * An interface that defines a facade access to the Trainer Service.
 * 
 * @author Oldrich Faldik
 */
public interface TrainerFacade {
    
        /**
        * Create new Trainer
        *
        * @param t TrainerCreateDTO - information about new Trainer
        * @return ID of new Trainer.
        */
        public Long createTrainer(TrainerCreateDTO t);
        
        /**
        * Delete existing Trainer
        *
        * @param trainerId ID of Trainer
        */
        public void deleteTrainer(Long trainerId);
        
        /**
        * Gets all existing Trainers
        * @return List of TrainerDTOs
        */
        public List<TrainerDTO> getAllTrainers();
        
        /**
        * Gets existing Trainer by ID
        *
        * @param id
        * @return TrainerDTO
        */
        public TrainerDTO getTrainerWithId(Long id);
        
        /**
        * Gets all existing Trainers, who have already been Gym Leaders
        *
        * @return List of TrainerDTOs
        */
        public List<TrainerDTO> getTrainersByIsGymLeader();
        
        /**
        * Gets all existing Trainers, who have collected amount of Badges
        *
        * @param badgesCount
        * @return List of TrainerDTOs
        */
        public List<TrainerDTO> getTrainersByCountOfBages(int badgesCount);
        
        /**
        * New badge for existing Trainer
        *
        * @param newBadge
        */
        public void addBadge(BadgeDTO newBadge);
        
        /**
        * Change state of Gym Leader
        *
        * @param isGymLeader 
        * 
        */
        public void changeIsGymLeader(Boolean isGymLeader);
        
        /**
        * Change name of Trainer
        *
        * @param newName 
        * 
        */
        public void changeName(String newName);
        
        /**
        * Change Surname of Trainer
        *
        * @param newSurname 
        * 
        */
        public void changeSurname(String newSurname);
        
        /**
        * Change Date Of Birth of Trainer
        *
        * @param newDateOfBirth 
        * 
        */
        public void changeDateOfBirth(Date newDateOfBirth);
        
}
