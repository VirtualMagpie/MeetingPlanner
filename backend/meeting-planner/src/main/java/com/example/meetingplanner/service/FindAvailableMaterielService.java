package com.example.meetingplanner.service;

import com.example.meetingplanner.RestrictionsCovidProperties;
import com.example.meetingplanner.model.Materiel;
import com.example.meetingplanner.service.db.MaterielMobileDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * Service qui, pour des contraintes spécifiées pour une réunion, récupère la liste des matériels
 * mobiles pouvant satisfaire ces contraintes.
 */
@AllArgsConstructor
@Service
public class FindAvailableMaterielService {

  private final RestrictionsCovidProperties restrictionsCovidProperties;
  private final MaterielMobileDbService materielMobileDbService;

  public Set<Materiel> find(Set<Integer> idTypeMaterielRequis, Instant debut, Instant fin) {
    return materielMobileDbService.searchAllAvailable(
        // On suppose que le matériel doit être disponible 1h avant la réunion (pour désinfection)
        debut.minus(restrictionsCovidProperties.getMinuteLibreAvant(), ChronoUnit.MINUTES),
        fin,
        idTypeMaterielRequis);
  }
}
