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
 * @author Oldrich Faldik
 */


public class TrainerDTO {

    private int id;

    private String fullName;

    private String email;

    private String password;

    private Date dateOfBirth;

    private Set<BadgeDTO> badges = new HashSet<>();

    private boolean isGymLeader = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGymLeader() {
        return isGymLeader;
    }

    public void setGymLeader(boolean gymLeader) {
        isGymLeader = gymLeader;
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
        hash = 79 * hash + Objects.hashCode(this.fullName);
        hash = 79 * hash + Objects.hashCode(this.email);
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
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
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
