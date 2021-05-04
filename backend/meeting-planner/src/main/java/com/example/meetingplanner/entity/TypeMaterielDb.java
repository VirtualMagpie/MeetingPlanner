package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entité représentant un des différents types de matériels pouvant être requis lors des réunions.
 *
 * <p>Ex : Ecran, Pieuvre, etc...
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "type_materiel")
public class TypeMaterielDb {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Nom d'affichage du type de matériel.
   *
   * <p>Ex : "Ecran"
   */
  @Column(name = "nom", nullable = false)
  private String nom;
}
