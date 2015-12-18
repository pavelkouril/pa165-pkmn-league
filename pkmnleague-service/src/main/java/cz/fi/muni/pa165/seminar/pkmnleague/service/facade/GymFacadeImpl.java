package cz.fi.muni.pa165.seminar.pkmnleague.service.facade;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Gym;
import cz.fi.muni.pa165.seminar.pkmnleague.domain.PokemonType;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymCreateDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.GymDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.dto.TrainerDTO;
import cz.fi.muni.pa165.seminar.pkmnleague.facade.GymFacade;
import cz.fi.muni.pa165.seminar.pkmnleague.service.BeanMappingService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.GymService;
import cz.fi.muni.pa165.seminar.pkmnleague.service.TrainerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zuzana Goldmannova
 */
@Service
@Transactional
public class GymFacadeImpl implements GymFacade {

    @Inject
    private GymService gymService;

    @Inject
    private TrainerService trainerService;

    @Inject
    private BeanMappingService beanMappingService;

    @Override
    public void createGym(GymCreateDTO g) {
        Gym mappedGym = beanMappingService.mapTo(g, Gym.class);
        gymService.create(mappedGym);
    }

    @Override
    public void deleteGym(int gymId) {
        gymService.delete(gymService.findById(gymId));
    }

    @Override
    public List<GymDTO> getAllGyms() {
        return beanMappingService.mapTo(gymService.findAll(), GymDTO.class);
    }

    @Override
    public GymDTO getGymWithId(int id) {
        return beanMappingService.mapTo(gymService.findById(id), GymDTO.class);
    }

    @Override
    public void changeCity(String newCity, int gymId) {
        Gym mappedGym = beanMappingService.mapTo(gymId, Gym.class);
        mappedGym.setCity(newCity);
    }

    @Override
    public List<GymDTO> getGymsByType(PokemonType type) {
        List<Gym> gyms = gymService.findAll();
        List<Gym> gymsType = new ArrayList<Gym>();
        for (Gym gym : gyms) {
            if (gym.getType().name().equals(type.name())) {
                gymsType.add(gym);
            }
        }
        List<GymDTO> dtog = beanMappingService.mapTo(gymsType, GymDTO.class);
        return dtog;
    }

    @Override
    public List<GymDTO> getGymsByLeader(int trainerId) {
        List<Gym> gyms = gymService.findAll();
        List<Gym> gymsLeader = new ArrayList<Gym>();
        for (Gym gym : gyms) {
            if (gym.getLeader().getId() == trainerId) {
                gymsLeader.add(gym);
            }
        }
        List<GymDTO> dtog = beanMappingService.mapTo(gymsLeader, GymDTO.class);
        return dtog;
    }

    @Override
    public void changeLeader(TrainerDTO newLeader, int gymId) {
        Gym mappedGym = beanMappingService.mapTo(gymId, Gym.class);
        trainerService.findById(newLeader.getId());
        mappedGym.setLeader(trainerService.findById(newLeader.getId()));
    }
}
