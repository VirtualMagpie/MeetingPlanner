package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Entité representant une salle.
 *
 * <p>Ex: Salle E1002, 10 places
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "salle")
public class SalleDb {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Nom d'affichage de la salle.
   *
   * <p>Ex: "E1002"
   */
  @Column(name = "nom", nullable = false)
  private String nom;

  /**
   * Capacité nominale de la salle en nombre de places.
   *
   * <p>Ex: 10
   */
  @Column(name = "capacite", nullable = false)
  private Integer capacite;

  /**
   * Matériels fixes présents dans cette salle.
   *
   * <p>Ex: écran + webcam
   */
  @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY)
  private Set<MaterielFixeDb> materielsFixes;

  // TODO: la table des réservations est amenée a beaucoup grossir (contrairement au autres),
  //  si bien que ce Set finira par devenir lourd à charger en mémoire et traiter.
  //  -> à corriger (faire une requête explicite pour charger uniquement les réservations utiles ?)
  /**
   * Réservations faites sur cette salle.
   *
   * <p>Ex: écran + webcam
   */
  @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY)
  private Set<ReservationDb> reservations;
}
