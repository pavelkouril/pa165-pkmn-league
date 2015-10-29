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
    @ManyToOne()
    @JoinColumn(name="TRAINER_ID")
    private Trainer leader;

    public Gym(String city, PokemonType type, Trainer leader) {
        this.city = city;
        this.type = type;
        this.leader = leader;
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
    public int hashCode() {
        int hash = this.id;
        hash = 31 * hash + Objects.hashCode(this.city);
        hash = 31 * hash + Objects.hashCode(this.type);
        hash = 31 * hash + Objects.hashCode(this.leader);
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
        final Gym other = (Gym) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.leader, other.leader)) {
            return false;
        }
        return true;
    }
    
    
    
}
