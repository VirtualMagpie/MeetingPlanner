package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

/**
 * Entite représentant une réservation (de salle et de matériel) dans le cadre d'une réunion. Une
 * réservation se fait nécessairement sur une salle, entre une horaire de début et un horaire de
 * fin. De plus, du matériel mobile peut être inclus dans la réservation pour compléter le matériel
 * déjà présent dans la salle.
 *
 * <p>Ex : Réservation de la salle E1001, le 03/05/2021 de 9h à 10h, visioconférence + 1 webcam
 * réservée
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class ReservationDb {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Identifiant permettant de déterminer qui a fait la réservation. Cet identifiant est fourni par
   * l'id provider (son format n'est donc pas maitrisé, on le stocke donc simplement comme une
   * string). On suppose que l'id provider nous assure l'unicité de cet id pour identifier un
   * utilisateur de l'application.
   */
  @Column(name = "id_reservateur", nullable = false)
  private String idReservateur;

  /** Salle réservée pour cette réunion. */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_salle", nullable = false)
  private SalleDb salle;

  /**
   * Type de réunion.
   *
   * <p>Ex : visioconférence
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_type_reunion", nullable = false)
  private TypeReunionDb typeReunion;

  // TODO: stocker nombre de personnes pour la réunion ?

  /** Début de la réunion. */
  @Column(name = "datetime_debut", nullable = false)
  private Instant datetimeDebut;

  // TODO: ajouter une contrainte en db pour assurer datetime_debut < datetime_fin

  /** Fin de la réunion. */
  @Column(name = "datetime_fin", nullable = false)
  private Instant datetimeFin;

  /**
   * Ensemble des matériels mobiles réservés pour cette réunions (cela n'inclut donc pas les
   * matériels fixes, déjà associés à la salle).
   */
  // ReservationDb is owner of the many-to-many relationship
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "reservation_materiel",
      joinColumns = {@JoinColumn(name = "id_reservation")},
      inverseJoinColumns = {@JoinColumn(name = "id_materiel_mobile")})
  private Set<MaterielMobileDb> materielReserve;
}
