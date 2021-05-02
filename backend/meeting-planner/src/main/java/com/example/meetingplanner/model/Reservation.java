package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.Set;

/**
 * Représentation d'une réservation
 */
@Builder
@Value
public class Reservation {
    Integer id;
    String idReservateur;
    Integer idTypeReunion;
    String nomTypeReunion;
    Salle salle;
    Set<Materiel> materielsMobiles;
    Instant debut;
    Instant fin;
}
