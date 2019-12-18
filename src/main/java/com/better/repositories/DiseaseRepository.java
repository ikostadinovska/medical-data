package com.better.repositories;

import com.better.model.entity.DiseaseEntity;
import com.better.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long> {

    List<DiseaseEntity> findAllByPatientByPatientId(PatientEntity entity);
}
