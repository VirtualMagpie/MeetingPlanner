package com.example.meetingplanner.repository;

import com.example.meetingplanner.entity.MaterielMobileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: check if this annotation is required
@Repository
public interface MaterielMobileRepository extends JpaRepository<MaterielMobileDb, Integer> {
}
