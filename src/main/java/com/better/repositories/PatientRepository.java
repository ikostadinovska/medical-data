package com.better.repositories;

import com.better.model.entity.DoctorEntity;
import com.better.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAllByDoctorByDoctorId(DoctorEntity doctorEntity);
}
