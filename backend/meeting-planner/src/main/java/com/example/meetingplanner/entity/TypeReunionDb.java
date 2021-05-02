package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Entité représentant un des différents types de réunion possible.
 * <p>
 * Ex : visioconférence (VC), réunion simple (RS), etc...
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "type_reunion")
public class TypeReunionDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // TODO: ajouter un code en plus du nom

    /**
     * Nom d'affichage du type de réunion
     * <p>
     * Ex : "visioconférence"
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    /**
     * Ensemble des matériels requis pour ce type de réunion
     * <p>
     * Ex : Ecran + Pieuvre + Webcam
     */
    // TypeReunionDb is owner of the many-to-many relationship
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "type-reunion-materiel-requis",
            joinColumns = {@JoinColumn(name = "id_type_reunion")},
            inverseJoinColumns = {@JoinColumn(name = "id_type_materiel")}

    )
    private Set<TypeMaterielDb> typeMaterielRequis;
}
