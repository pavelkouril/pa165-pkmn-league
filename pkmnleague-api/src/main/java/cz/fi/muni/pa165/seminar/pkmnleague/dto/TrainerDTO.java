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

    private Set<PokemonDTO> pokemon = new HashSet<>();

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

    public Set<PokemonDTO> getPokemon() {
        return pokemon;
    }

    public void setPokemon(Set<PokemonDTO> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.fullName);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
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
        return true;
    }

}
