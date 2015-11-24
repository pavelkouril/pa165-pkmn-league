package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.domain.Badge;

import java.util.List;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface BadgeService {
    Badge findById(int id);
    List<Badge> findAll();
    void delete(Badge gym);
}
