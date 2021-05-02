package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

/**
 * Représentation d'un type de réunion.
 */
@Builder
@Value
public class TypeReunion {
    Integer id;
    String nom;
}
