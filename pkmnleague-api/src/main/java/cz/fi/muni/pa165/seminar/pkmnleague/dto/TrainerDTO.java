/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Oldrich Faldik
 */


public class TrainerDTO
{
   
    private int id;

    private String name;

    private String surname;

    private Date dateOfBirth;

    private Set<BadgeDTO> badges = new HashSet<>();

    private boolean isGymLeader = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<BadgeDTO> getBadges() {
        return badges;
    }

    public void setBadges(Set<BadgeDTO> badges) {
        this.badges = badges;
    }

    public boolean isIsGymLeader() {
        return isGymLeader;
    }

    public void setIsGymLeader(boolean isGymLeader) {
        this.isGymLeader = isGymLeader;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.surname);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 79 * hash + (this.isGymLeader ? 1 : 0);
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
        final TrainerDTO other = (TrainerDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (this.isGymLeader != other.isGymLeader) {
            return false;
        }
        return true;
    }

   

}
