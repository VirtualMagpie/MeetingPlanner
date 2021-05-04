package com.example.meetingplanner.service.db;

import com.example.meetingplanner.entity.TypeMaterielDb;
import com.example.meetingplanner.entity.TypeReunionDb;
import com.example.meetingplanner.model.TypeMateriel;
import com.example.meetingplanner.model.TypeReunion;
import com.example.meetingplanner.repository.TypeReunionRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;

/** Unit test for {@link TypeReunionDbService} */
@ExtendWith(MockitoExtension.class)
public class TypeReunionDbServiceTest {

  @Mock private TypeReunionRepository typeReunionRepository;
  @InjectMocks private TypeReunionDbService service;

  /** Unit test for method {@link TypeReunionDbService#fetchAll} */
  @Nested
  class FetchAll {

    @Test
    void whenNoResult() {
      // [GIVEN] No entity in db
      lenient().doReturn(List.of()).when(typeReunionRepository).findAll();
      // [WHEN] Calling method
      Set<TypeReunion> result = service.fetchAll();
      // [THEN] Empty result
      assertThat(result).isEmpty();
    }

    @Test
    void whenSomeResult() {
      // [GIVEN] Some entities in db
      TypeReunionDb typeReunionDb1 = new TypeReunionDb();
      typeReunionDb1.setId(1);
      TypeReunionDb typeReunionDb2 = new TypeReunionDb();
      typeReunionDb2.setId(2);
      lenient()
          .doReturn(List.of(typeReunionDb1, typeReunionDb2))
          .when(typeReunionRepository)
          .findAll();
      // [WHEN] Calling method
      Set<TypeReunion> result = service.fetchAll();
      // [THEN] Found 2 expected entities
      TypeReunion expected1 = TypeReunion.builder().id(1).build();
      TypeReunion expected2 = TypeReunion.builder().id(2).build();
      assertThat(result).containsExactlyInAnyOrder(expected1, expected2);
    }
  }

  /** Unit test for method {@link TypeReunionDbService#fetchAllTypeMaterielRequis} */
  @Nested
  class FetchAllTypeMaterielRequis {

    private final Integer ID = 1;

    @Test
    void whenNotFound() {
      // [GIVEN] No entity in db for this id
      lenient().doReturn(Optional.empty()).when(typeReunionRepository).findById(ID);
      // [WHEN] Calling method for this id
      Set<TypeMateriel> result = service.fetchAllTypeMaterielRequis(ID);
      // [THEN] Result is empty
      // TODO: should throw instead?
      assertThat(result).isEmpty();
    }

    @Test
    void whenFoundWithoutTypeMaterielRequis() {
      // [GIVEN] An entity without type materiel for this id
      TypeReunionDb typeReunionDb = new TypeReunionDb();
      typeReunionDb.setId(1);
      typeReunionDb.setTypeMaterielRequis(Set.of());
      lenient().doReturn(Optional.of(typeReunionDb)).when(typeReunionRepository).findById(ID);
      // [WHEN] Calling method for this id
      Set<TypeMateriel> result = service.fetchAllTypeMaterielRequis(ID);
      // [THEN] Result is empty
      assertThat(result).isEmpty();
    }

    @Test
    void whenFoundWithSomeTypeMaterielRequis() {
      // [GIVEN] An entity with some type materiel for this id
      TypeMaterielDb typeMaterielDb1 = new TypeMaterielDb();
      typeMaterielDb1.setId(1);
      TypeMaterielDb typeMaterielDb2 = new TypeMaterielDb();
      typeMaterielDb2.setId(2);
      TypeReunionDb typeReunionDb = new TypeReunionDb();
      typeReunionDb.setId(3);
      typeReunionDb.setTypeMaterielRequis(Set.of(typeMaterielDb1, typeMaterielDb2));
      lenient().doReturn(Optional.of(typeReunionDb)).when(typeReunionRepository).findById(ID);
      // [WHEN] Calling method for this id
      Set<TypeMateriel> result = service.fetchAllTypeMaterielRequis(ID);
      // [THEN] Result is empty
      TypeMateriel expected1 = TypeMateriel.builder().id(1).build();
      TypeMateriel expected2 = TypeMateriel.builder().id(2).build();
      assertThat(result).containsExactlyInAnyOrder(expected1, expected2);
    }
  }
}
