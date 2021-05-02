package com.example.meetingplanner.repository;

import com.example.meetingplanner.entity.TypeMaterielDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: check if this annotation is required
@Repository
public interface TypeMaterielRepository extends JpaRepository<TypeMaterielDb, Integer> {
}
