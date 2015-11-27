/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.dto.PokemonCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.PokemonDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.enums.PokemonType;
import java.util.List;

/**
 * An interface that defines a facade access to the Pokemon Service.
 * 
 * @author Oldrich Faldik
 */
public interface PokemonFacade {
    
        /**
        * Create new Pokemon
        *
        * @param p PokemonCreateDTO - information about new Pokemon
        * @return ID of new Pokemon.
        */
        public Long createPokemon(PokemonCreateDTO p);
        
        /**
        * Delete existing Pokemon
        *
        * @param pokemonId ID of Pokemon
        */
        public void deletePokemon(Long pokemonId);
        
        /**
        * Gets all existing Pokemons
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getAllPokemons();
        
        /**
        * Gets existing Pokemon by ID
        *
        * @param id
        * @return PokemonDTO
        */
        public PokemonDTO getPokemonWithId(Long id);
        
        /**
        * Gets existing Pokemons by Trainer ID
        *
        * @param trainerId 
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsByTrainer(Long trainerId);
        
        /**
        * Gets existing Pokemons by Primary Type
        *
        * @param type 
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsByPrimaryType(PokemonType type);
        
        /**
        * Gets existing Pokemons by Secondary Type
        *
        * @param type 
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsBySecondaryType(PokemonType type);
        
        /**
        * Gets existing Pokemons by Level
        *
        * @param level number of level 
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsByLevel(int level);
        
        /**
        * Gets existing Pokemons by Species Name
        *
        * @param speciesName
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsBySpeciesName(String speciesName);
        
        /**
        * Change Species Name of existing Pokemon
        *
        * @param newSpeciesName 
        * 
        */
        public void changeSpeciesName(String newSpeciesName);
        
        /**
        * Change Nick Name of existing Pokemon
        *
        * @param newNickName 
        * 
        */
        public void changeNickName(String newNickName);
        
        /**
        * Change Primary Type of existing Pokemon
        *
        * @param newType 
        * 
        */
        public void changePrimaryType(PokemonType newType);
        
        /**
        * Change Secondary Type of existing Pokemon
        *
        * @param newType 
        * 
        */
        public void changeSecondaryType(PokemonType newType);
        
        /**
        * Change Level of existing Pokemon
        *
        * @param newLevel 
        * 
        */
        public void changeLevel(int newLevel);
        
        /**
        * Change Trainer of existing Pokemon
        *
        * @param newTrainer 
        * 
        */
        public void changeTrainer(TrainerDTO newTrainer);
        
}
