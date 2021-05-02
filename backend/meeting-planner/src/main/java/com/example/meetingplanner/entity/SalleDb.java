package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * Entité representant une salle.
 * <p>
 * Ex: Salle E1002, 10 places
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
     * <p>
     * Ex: "E1002"
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    /**
     * Capacité nominale de la salle en nombre de places.
     * Ex: 10
     */
    @Column(name = "capacite", nullable = false)
    private Integer capacite;

    // TODO: utiliser le OneToMany pour directement accéder à la liste des équipements présents ?
    // TODO: changer description
}
