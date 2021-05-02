package com.example.meetingplanner.service;

import com.example.meetingplanner.model.EntitiesToBook;
import com.example.meetingplanner.model.Materiel;
import com.example.meetingplanner.model.Salle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

/**
 * Service qui, parmi les choix possibles d'entités disponibles à une réservation, choisit le "meilleur" ensemble
 * d'entité qui respecte les contraintes posées.
 */
@AllArgsConstructor
@Service
public class ChooseEntitiesToBookService {

    private final FindAvailableSalleService findAvailableSalleService;
    private final FindAvailableMaterielService findAvailableMaterielService;

    public EntitiesToBook choose(
            Integer idTypeReunion,
            Integer nombrePersonne,
            Instant debut,
            Instant fin
    ) {
        Set<Salle> salles = findAvailableSalleService.find(nombrePersonne, debut, fin);
        Set<Materiel> materiels = findAvailableMaterielService.find(idTypeReunion, debut, fin);
        return chooseFromAvailableEntities(idTypeReunion, salles, materiels);
    }

    private EntitiesToBook chooseFromAvailableEntities(
            Integer idTypeReunion, // TODO: récupérer plutôt la liste des matériels requis
            Set<Salle> salles,
            Set<Materiel> materiels

    ) {
        // TODO: to implement
        return EntitiesToBook.builder().build();
    }
}
