package cz.fi.muni.pa165.seminar.pkmnleague.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private boolean isGymLeader = false;

    public Trainer(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Trainer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer trainer = (Trainer) o;

        if (id != trainer.id) return false;
        if (name != null ? !name.equals(trainer.name) : trainer.name != null) return false;
        if (surname != null ? !surname.equals(trainer.surname) : trainer.surname != null) return false;
        return !(dateOfBirth != null ? !dateOfBirth.equals(trainer.dateOfBirth) : trainer.dateOfBirth != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
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

    public boolean isGymLeader() {
        return isGymLeader;
    }

    public void setIsGymLeader(boolean isGymLeader) {
        this.isGymLeader = isGymLeader;
    }
}
