package cz.fi.muni.pa165.seminar.pkmnleague.service.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Badge;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.Trainer;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.BadgeDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.TrainerFacade;
import cz.fi.muni.pa165.seminar.pkmnleague.service.BadgeService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.BeanMappingService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.GymService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.TrainerService;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zuzana Goldmannova
 */
@Service
@Transactional
public class TrainerFacadeImpl implements TrainerFacade {

    @Inject
    private TrainerService trainerService;

    @Inject
    private GymService gymService;

    @Inject
    private BadgeService badgeService;

    @Inject
    private BeanMappingService beanMappingService;

    @Override
    public void createTrainer(TrainerCreateDTO t) {
        Trainer mappedTrainer = beanMappingService.mapTo(t, Trainer.class);

        mappedTrainer.setName(t.getName());
        mappedTrainer.setSurname(t.getSurname());
        mappedTrainer.setDateOfBirth((java.sql.Date) t.getDateOfBirth());

        trainerService.create(mappedTrainer);
    }

    @Override
    public void deleteTrainer(int trainerId) {
        trainerService.delete(trainerService.findById(trainerId));
    }

    @Override
    public List<TrainerDTO> getAllTrainers() {
        return beanMappingService.mapTo(trainerService.findAll(), TrainerDTO.class);
    }

    @Override
    public TrainerDTO getTrainerWithId(int id) {
        return beanMappingService.mapTo(trainerService.findById(id), TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> getTrainersByIsGymLeader() {
        List<Trainer> trainers = trainerService.findAll();
        List<Trainer> trainersLeaders = new ArrayList<Trainer>();
        for (Trainer trainer : trainers) {
            if (trainerService.isGymLeader(trainer)) {
                trainersLeaders.add(trainerService.findById(trainer.getId()));
            }
        }
        final List<TrainerDTO> dtot = beanMappingService.mapTo(trainersLeaders, TrainerDTO.class);
        return dtot;
    }

    @Override
    public List<TrainerDTO> getTrainersByCountOfBages(int badgesCount) {
        List<Trainer> trainers = trainerService.findAll();
        List<Trainer> trainersBadges = new ArrayList<Trainer>();
        for (Trainer trainer : trainers) {
            if (badgeService.getAllBadgesByTrainer(trainer).size() == badgesCount) {
                trainersBadges.add(trainerService.findById(trainer.getId()));
            }
        }
        final List<TrainerDTO> dtot = beanMappingService.mapTo(trainersBadges, TrainerDTO.class);
        return dtot;
    }

    @Override
    public void addBadge(BadgeDTO newBadge, int trainerId) {
        Badge mappedBadge = beanMappingService.mapTo(newBadge, Badge.class);
        gymService.awardBadgeToTrainer(mappedBadge.getGym(), trainerService.findById(trainerId));
    }


    @Override
    public void changeName(String newName, int trainerId) {
        Trainer mappedTrainer = beanMappingService.mapTo(trainerId, Trainer.class);
        mappedTrainer.setName(newName);
    }

    @Override
    public void changeSurname(String newSurname, int trainerId) {
        Trainer mappedTrainer = beanMappingService.mapTo(trainerId, Trainer.class);
        mappedTrainer.setSurname(newSurname);
    }

    @Override
    public void changeDateOfBirth(Date newDateOfBirth, int trainerId) {
        Trainer mappedTrainer = beanMappingService.mapTo(trainerId, Trainer.class);
        mappedTrainer.setDateOfBirth((java.sql.Date) newDateOfBirth);
    }

}
