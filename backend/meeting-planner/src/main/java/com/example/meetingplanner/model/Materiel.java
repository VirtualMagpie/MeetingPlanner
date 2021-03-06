package com.example.meetingplanner.model;

import lombok.Builder;
import lombok.Value;

/**
 * Représentation d'un matériel de réunion
 */
@Builder
@Value
public class Materiel {
    Integer id;
    TypeMateriel typeMateriel;
    Boolean mobile;
}
