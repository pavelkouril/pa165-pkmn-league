/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.seminar.pkmnleague.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Oldrich Faldik
 */
@Entity
public class Gym implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private String city;
    
    @NotNull
    @Column(nullable = false)
    private PokemonType type;
    
    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TRAINER_ID")
    private Trainer leader;

    public Gym(String city, PokemonType type, Trainer leader) {
        this.city = city;
        this.type = type;
        this.leader = leader;
    }

    protected Gym() {
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public PokemonType getType() {
        return type;
    }

    public Trainer getLeader() {
        return leader;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public void setLeader(Trainer leader) {
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gym)) return false;

        Gym gym = (Gym) o;

        if (!getCity().equals(gym.getCity())) return false;
        return getLeader().equals(gym.getLeader());

    }

    @Override
    public int hashCode() {
        int result = getCity().hashCode();
        result = 31 * result + getLeader().hashCode();
        return result;
    }
}
