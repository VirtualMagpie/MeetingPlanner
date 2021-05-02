package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

/**
 * Représentation d'une salle.
 */
@Builder
@Value
public class Salle {
    Integer id;
    String nom;
    Integer capacite;
    Set<Materiel> materiels;
}
