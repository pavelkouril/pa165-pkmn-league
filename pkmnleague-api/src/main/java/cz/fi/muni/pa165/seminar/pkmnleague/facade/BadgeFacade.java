/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.BadgeCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.BadgeDTO;
import java.util.List;

/**
 * An interface that defines a facade access to the Badge Service.
 * 
 * @author Oldrich Faldik
 */
public interface BadgeFacade {
    
        /**
        * Create new Badge belonging to Trainer
        *
        * @param b BadgeCreateDTO - information about new Badge
        * @return ID of new Badge.
        */
        public Long createBadge(BadgeCreateDTO b);
        
        /**
        * Delete existing Badge 
        *
        * @param badgeId ID of Bagde
        */
        public void deleteBadge(Long badgeId);
        
        /**
        * Gets all existing Badges
        * @return List of BadgeDTOs
        */
        public List<BadgeDTO> getAllBadges();
        
        /**
        * Gets existing Badge by ID
        *
        * @param id
        * @return BadgeDTO
        */
        public BadgeDTO getBadgeWithId(Long id);
        
        /**
        * Gets existing Badges by Trainer ID
        *
        * @param trainerId 
        * @return List of BadgeDTOs
        */
        public List<BadgeDTO> getBadgesByTrainer(Long trainerId);
        
        /**
        * Gets existing Badges by Gym ID
        *
        * @param gymId 
        * @return List of BadgeDTOs
        */
        public List<BadgeDTO> getBadgesByGym(Long gymId);
    
}
