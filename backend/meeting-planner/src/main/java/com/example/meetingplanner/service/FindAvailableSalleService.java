package com.example.meetingplanner.service;

import com.example.meetingplanner.model.Salle;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

/**
 * Service qui, pour des contraintes spécifiées pour une réunion, récupère la liste des salles pouvant satisfaire ces
 * contraintes.
 */
@Service
public class FindAvailableSalleService {

    public Set<Salle> find(
            Integer nombrePersonne,
            Instant debut,
            Instant fin
    ) {
        // TODO: to implement
        return Collections.emptySet();
    }
}
