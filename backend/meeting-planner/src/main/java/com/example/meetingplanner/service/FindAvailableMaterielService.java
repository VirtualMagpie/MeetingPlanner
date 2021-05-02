package com.example.meetingplanner.service;

import com.example.meetingplanner.model.Materiel;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

/**
 * Service qui, pour des contraintes spécifiées pour une réunion, récupère la liste des matériels mobiles pouvant
 * satisfaire ces contraintes.
 */
@Service
public class FindAvailableMaterielService {

    public Set<Materiel> find(
            Integer idTypeReunion,
            Instant debut,
            Instant fin
    ) {
        // TODO: to implement
        return Collections.emptySet();
    }
}
