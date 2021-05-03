package com.example.meetingplanner.service.db.specification;

import com.example.meetingplanner.entity.SalleDb;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Set;

/**
 * Specification pour récupérer l'ensemble des salles disponibles respectant les contraintes posées.
 */
@AllArgsConstructor
public class SalleAvailableSpecification implements Specification<SalleDb> {

  private Integer nombrePlace;
  private Set<Integer> idSallesOccupees;

  @Override
  public Predicate toPredicate(
      Root<SalleDb> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

    Predicate sufficientSpace =
        criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("capacite"), nombrePlace);
    Predicate notAlreadyOccupied =
        idSallesOccupees.size() > 0
            ? criteriaBuilder.not(root.<Integer>get("id").in(idSallesOccupees))
            // Hibernate would create a clause "salle.id not in (null)" when we use previous
            // criteria on an empty set. This clause is not working and return no result. To prevent
            // this, we use an always true predicate instead when this set is empty.
            : criteriaBuilder.conjunction();

    return criteriaBuilder.and(sufficientSpace, notAlreadyOccupied);
  }
}
