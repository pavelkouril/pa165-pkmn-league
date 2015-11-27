package cz.fi.muni.pa165.seminar.pkmnleague.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for Trainer object.
 *
 * @author dhanak @domhanak on 10/28/15.
 */
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String surname;

    @NotNull
    @Column(nullable = false)
    private Date dateOfBirth;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Badge> badges = new HashSet<>();

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Pokemon> pokemon = new HashSet<>();

    public Trainer(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    protected Trainer() {
    }

    public int getId() {
        return id;
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

    public void setDateOfBirth(java.sql.Date date) {
        this.dateOfBirth = date;
    }

    void addBadge(Badge badge) {
        badges.add(badge);
    }

    public Set<Badge> getBadges() {
        return Collections.unmodifiableSet(badges);
    }

    public Set<Pokemon> getPokemon() {
        return Collections.unmodifiableSet(pokemon);
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            this.pokemon.add(pokemon);
        }
    }

    public void addPokemon(Collection<Pokemon> pokemon) {
        if (pokemon != null) {
            this.pokemon.addAll(pokemon);
        }
    }

    public boolean isGymLeaderAtGym(Gym gym) {
        return gym.getLeader().equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;

        Trainer trainer = (Trainer) o;

        if (!getName().equals(trainer.getName())) return false;
        if (!getSurname().equals(trainer.getSurname())) return false;
        return getDateOfBirth().equals(trainer.getDateOfBirth());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        return result;
    }
}
