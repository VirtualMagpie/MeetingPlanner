package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Entité représentant un matériel mobile, c'est-à-dire n'étant pas associé à une salle et devant donc faire l'objet
 * d'une réservation pour être utilisé dans la cadre d'une réunion.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "materiel-mobile")
public class MaterielMobileDb {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Type de matériel
     * <p>
     * Ex : Ecran, Pieuvre, etc...
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_materiel", nullable = false)
    private TypeMaterielDb typeMateriel;

    // TODO: a priori on n'utilisera pas cette jointure dans ce sens. A supprimer ?
    /**
     * Ensemble des réservations où ce matériel est réservé.
     */
    // MaterielMobileDb is NOT owner of the many-to-many relationship
    @ManyToMany(mappedBy = "materielReserve", fetch = FetchType.LAZY)
    private Set<ReservationDb> reservations;
}
