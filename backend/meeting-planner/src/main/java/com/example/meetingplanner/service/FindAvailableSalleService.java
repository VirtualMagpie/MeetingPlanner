package com.example.meetingplanner.service;

import com.example.meetingplanner.model.Salle;
import com.example.meetingplanner.service.db.SalleDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * Service qui, pour des contraintes spécifiées pour une réunion, récupère la liste des salles
 * pouvant satisfaire ces contraintes.
 */
@AllArgsConstructor
@Service
public class FindAvailableSalleService {

  private final SalleDbService salleDbService;

  public Set<Salle> find(Integer nombrePersonne, Instant debut, Instant fin) {
    // TODO: mettre durée et ratio en config
    return salleDbService.searchAllAvailable(
        // La doit être disponible 1h avant la réunion (pour désinfection)
        debut.minus(1, ChronoUnit.HOURS),
        fin,
        // La salle ne peut être occupée qu'à 70%
        (int) Math.ceil(nombrePersonne / 0.7));
  }
}
