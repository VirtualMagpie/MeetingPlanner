package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

/**
 * Contient les entités choisies pour une réservation.
 */
@Builder
@Value
public class EntitiesToBook {
    Salle salle;
    Set<Materiel> materielsMobiles;
}
