package com.example.meetingplanner.repository;

import com.example.meetingplanner.entity.MaterielFixeDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: check if this annotation is required
@Repository
public interface MaterielFixeRepository extends JpaRepository<MaterielFixeDb, Integer> {
}
