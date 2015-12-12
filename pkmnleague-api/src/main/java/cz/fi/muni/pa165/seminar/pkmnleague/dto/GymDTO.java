/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dto;

import cz.fi.muni.pa165.seminar.pkmnleague.enums.PokemonType;
import java.util.Objects;

/**
 *
 * @author Oldrich Faldik
 */


public class GymDTO
{

    private int id;
    
    private String city;
    
    private PokemonType type;
    
    private TrainerDTO leader;
    
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public TrainerDTO getLeader() {
        return leader;
    }

    public void setLeader(TrainerDTO leader) {
        this.leader = leader;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.city);
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.leader);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GymDTO other = (GymDTO) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.leader, other.leader)) {
            return false;
        }
        return true;
    }

   

}
