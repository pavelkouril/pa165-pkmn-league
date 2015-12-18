package cz.fi.muni.pa165.seminar.pkmnleague.dto;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oldrich Faldik
 */
public class PokemonCreateDTO {
    
    @Min(0)
    private int speciesId;

    @NotNull
    @Size(min = 4, max = 40)
    private String speciesName;
 
    @NotNull
    @Size(min = 4, max = 40)
    private String nickname;

    @NotNull
    private PokemonType primaryType;

    @NotNull
    private PokemonType secondaryType;

    @Min(0)
    private int level;

    @NotNull
    private TrainerDTO trainer;

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public PokemonType getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(PokemonType primaryType) {
        this.primaryType = primaryType;
    }

    public PokemonType getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(PokemonType secondaryType) {
        this.secondaryType = secondaryType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TrainerDTO getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDTO trainer) {
        this.trainer = trainer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.speciesId;
        hash = 37 * hash + Objects.hashCode(this.speciesName);
        hash = 37 * hash + Objects.hashCode(this.nickname);
        hash = 37 * hash + Objects.hashCode(this.primaryType);
        hash = 37 * hash + Objects.hashCode(this.secondaryType);
        hash = 37 * hash + this.level;
        hash = 37 * hash + Objects.hashCode(this.trainer);
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
        final PokemonCreateDTO other = (PokemonCreateDTO) obj;
        if (this.speciesId != other.speciesId) {
            return false;
        }
        if (!Objects.equals(this.speciesName, other.speciesName)) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (this.primaryType != other.primaryType) {
            return false;
        }
        if (this.secondaryType != other.secondaryType) {
            return false;
        }
        if (this.level != other.level) {
            return false;
        }
        if (!Objects.equals(this.trainer, other.trainer)) {
            return false;
        }
        return true;
    }
    
    
    
}
