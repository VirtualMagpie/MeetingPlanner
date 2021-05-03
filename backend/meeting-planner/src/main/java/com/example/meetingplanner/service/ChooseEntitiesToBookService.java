package com.example.meetingplanner.service;

import com.example.meetingplanner.model.EntitiesToBook;
import com.example.meetingplanner.model.Materiel;
import com.example.meetingplanner.model.Salle;
import com.example.meetingplanner.model.TypeMateriel;
import com.example.meetingplanner.service.db.TypeReunionDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service qui, parmi les choix possibles d'entités disponibles à une réservation, choisit le
 * "meilleur" ensemble d'entité qui respecte les contraintes posées.
 */
@AllArgsConstructor
@Service
public class ChooseEntitiesToBookService {

  private final TypeReunionDbService typeReunionDbService;
  private final FindAvailableSalleService findAvailableSalleService;
  private final FindAvailableMaterielService findAvailableMaterielService;

  public EntitiesToBook choose(
      Integer idTypeReunion, Integer nombrePersonne, Instant debut, Instant fin) {
    Set<Integer> idTypeMaterielRequis =
        typeReunionDbService.fetchAllTypeMaterielRequis(idTypeReunion).stream()
            .map(TypeMateriel::getId)
            .collect(Collectors.toSet());
    Set<Salle> salles = findAvailableSalleService.find(nombrePersonne, debut, fin);
    Set<Materiel> materiels = findAvailableMaterielService.find(idTypeMaterielRequis, debut, fin);
    return chooseFromAvailableEntities(idTypeMaterielRequis, salles, materiels);
  }

  private EntitiesToBook chooseFromAvailableEntities(
      Set<Integer> idTypeMaterielRequis, Set<Salle> salles, Set<Materiel> materiels) {

    // TODO: to implement
    return EntitiesToBook.builder()
        // TODO: to change
        .salle(salles.stream().findAny().orElse(null))
        // TODO: to change
        .materielsMobiles(materiels)
        .build();
  }
}
