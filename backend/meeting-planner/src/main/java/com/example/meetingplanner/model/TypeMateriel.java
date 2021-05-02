package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

/**
 * Représentation d'un type de matériel.
 */
@Builder
@Value
public class TypeMateriel {
    Integer id;
    String nom;
}
