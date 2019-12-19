package com.better.repositories;

import com.better.model.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
