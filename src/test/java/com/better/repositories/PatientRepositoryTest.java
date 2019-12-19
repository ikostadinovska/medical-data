package com.better.repositories;

import com.better.model.entity.DiseaseEntity;
import com.better.model.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void findOneById() {
        PatientEntity entity = new PatientEntity();
        entity.setId(123L);
        entity.setFirstName("Miha");
        entity.setLastName("Novak");
        patientRepository.save(entity);

        Optional<PatientEntity> patientEntity = patientRepository.findById(123L);
        assertTrue(patientEntity.isPresent());
        assertEquals(patientEntity.get().getFirstName(), "Miha");
        assertEquals(patientEntity.get().getLastName(), "Novak");
    }

    @Test
    void listDiseases() {
        PatientEntity entity = new PatientEntity();
        entity.setId(123L);
        entity.setFirstName("Miha");
        entity.setLastName("Novak");

        Collection<DiseaseEntity> diseases = new ArrayList<>();
        DiseaseEntity diseaseEntity = new DiseaseEntity();
        diseaseEntity.setDiseaseName("disease_01");
        diseaseEntity.setId(1L);
        diseaseEntity.setPatientByPatientId(entity);

        entity.setDiseasesById(diseases);
        patientRepository.save(entity);
        diseaseRepository.save(diseaseEntity);

        List<DiseaseEntity> diseasesListDb = diseaseRepository.findAllByPatientByPatientId(entity);

        assertEquals(1, diseasesListDb.size());
    }
}