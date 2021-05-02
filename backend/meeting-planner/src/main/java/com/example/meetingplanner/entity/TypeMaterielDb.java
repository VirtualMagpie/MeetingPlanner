package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Entité représentant un des différents types de matériels pouvant être requis lors des réunions.
 * <p>
 * Ex : Ecran, Pieuvre, etc...
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
     * <p>
     * Ex : "Ecran"
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    // TODO: a priori on n'utilisera pas cette jointure-ci dans ce sens -> à supprimer ?
    /**
     * Ensemble des types de réunion qui nécessite ce matériel
     */
    // TypeMaterielDb is NOT owner of the many-to-many relationship
    @ManyToMany(mappedBy = "typeMaterielRequis", fetch = FetchType.LAZY)
    private Set<TypeReunionDb> typeReunionRequerant;
}
