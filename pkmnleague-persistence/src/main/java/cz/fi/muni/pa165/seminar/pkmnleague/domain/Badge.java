package cz.fi.muni.pa165.seminar.pkmnleague.domain;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Zuzana Goldmannova
 */
@Entity
public class Badge {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="TRAINER_ID")
    private Trainer trainer;

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="GYM_ID")
    private Gym gym;
    
    public Badge(Trainer trainer, Gym gym) {
        this.trainer = trainer;
        this.gym = gym;

    }
    
    public int getId() {
        return id;
    }
    
    public Trainer getTrainer() {
        return trainer;
    }
    
    public Gym getGym() {
        return gym;
    }
    
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    public void setGym(Gym gym) {
        this.gym = gym;
    }
    
    @Override
    public int hashCode() {
        int hash = this.id;
        hash = 31 * hash + Objects.hashCode(this.gym);
        hash = 31 * hash + Objects.hashCode(this.trainer);
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
        final Badge other = (Badge) obj;

        if (!Objects.equals(this.gym, other.gym)) {
            return false;
        }
        if (!Objects.equals(this.trainer, other.trainer)) {
            return false;
        }
        return true;
    }
}
