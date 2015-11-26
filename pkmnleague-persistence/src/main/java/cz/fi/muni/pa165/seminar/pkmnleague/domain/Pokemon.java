package cz.fi.muni.pa165.seminar.pkmnleague.domain;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Pavel Kouřil
 */
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(nullable = false)
    private int speciesId;

    @NotNull
    @Column(nullable = false)
    private String speciesName;

    @Column()
    private String nickname;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PokemonType primaryType;

    @Column()
    @Enumerated(EnumType.STRING)
    private PokemonType secondaryType;

    @NotNull
    @Column(nullable = false)
    private int level;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="TRAINER_ID")
    private Trainer trainer;

    public Pokemon() {
    }

    public Pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, int level) {
        this.speciesId = speciesId;
        this.speciesName = speciesName;
        this.primaryType = primaryType;
        this.level = level;
        this.trainer = trainer;
    }

    public Pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, PokemonType secondaryType, int level) {
        this.speciesId = speciesId;
        this.speciesName = speciesName;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.level = level;
        this.trainer = trainer;
    }

    public int getId() {
        return id;
    }

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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public int hashCode() {
        int hash = speciesId;
        hash = 53 * hash + this.speciesId;
        hash = 53 * hash + Objects.hashCode(this.speciesName);
        hash = 53 * hash + Objects.hashCode(this.nickname);
        hash = 53 * hash + Objects.hashCode(this.trainer);
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
        final Pokemon other = (Pokemon) obj;
        if (this.speciesId != other.speciesId) {
            return false;
        }
        if (!Objects.equals(this.speciesName, other.speciesName)) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        return true;
    }


}
