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
        */
        public void createPokemon(PokemonCreateDTO p);
        
        /**
        * Delete existing Pokemon
        *
        * @param pokemonId ID of Pokemon
        */
        public void deletePokemon(int pokemonId);
        
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
        public PokemonDTO getPokemonWithId(int id);
        
        /**
        * Gets existing Pokemons by Trainer ID
        *
        * @param trainerId 
        * @return List of PokemonDTOs
        */
        public List<PokemonDTO> getPokemonsByTrainer(int trainerId);
        
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
        * @param pokemonId 
        * 
        */
        public void changeSpeciesName(String newSpeciesName, int pokemonId);
        
        /**
        * Change Nick Name of existing Pokemon
        *
        * @param newNickName 
        * @param pokemonId 
        * 
        */
        public void changeNickName(String newNickName, int pokemonId);
        
//        /**
//        * Change Primary Type of existing Pokemon
//        *
//        * @param newType 
//        * @param pokemonId 
//        * 
//        */
//        public void changePrimaryType(PokemonType newType, int pokemonId);
//        
//        /**
//        * Change Secondary Type of existing Pokemon
//        *
//        * @param newType 
//        * @param pokemonId 
//        * 
//        */
//        public void changeSecondaryType(PokemonType newType, int pokemonId);
        
        /**
        * Change Level of existing Pokemon
        *
        * @param newLevel 
        * @param pokemonId 
        * 
        */
        public void changeLevel(int newLevel, int pokemonId);
        
        /**
        * Change Trainer of existing Pokemon
        *
        * @param newTrainer 
        * @param pokemonId 
        * 
        */
        public void changeTrainer(TrainerDTO newTrainer, int pokemonId);
        
}
