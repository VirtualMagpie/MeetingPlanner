package com.example.meetingplanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entité représentant un matériel fixe, c'est-à-dire lié à une salle et ne pouvant pas être déplacé.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "materiel-fixe")
public class MaterielFixeDb {

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
    
    /**
     * Salle dans laquel ce matériel est présent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_salle", nullable = false)
    private SalleDb salle;
}
