package com.better.repositories;

import com.better.model.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
