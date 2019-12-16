package com.better.bean;

import com.better.model.dao.DoctorEntity;
import com.better.model.dto.Doctor;
import com.better.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Component
public class MedicalDataBean {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor){
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctor.getId());
        doctorEntity.setDepartment(doctor.getDepartment());
        doctorRepository.save(doctorEntity);

        doctor.setId(doctorEntity.getId());

        return doctor;
    }

}
