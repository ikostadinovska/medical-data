package com.better.repositories;

import com.better.model.entity.DiseaseEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class DiseaseRepositoryTest {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Test
    void findAllByPatientByPatientId() {
        List<DiseaseEntity> diseases = diseaseRepository.findAllByPatientByPatientId(null);
        assertTrue(diseases.isEmpty());
    }

    @Test
    void saveAndGetDisease() {
        DiseaseEntity entity = new DiseaseEntity();
        entity.setDiseaseName("test_disease");
        diseaseRepository.save(entity);

        Optional<DiseaseEntity> disease= diseaseRepository.findById(entity.getId());

        assertTrue(disease.isPresent());
        assertEquals(disease.get().getDiseaseName(),"test_disease");
    }

    @Test
    void findUnknownDisease() {
        Optional<DiseaseEntity> disease= diseaseRepository.findById(123L);
        assertFalse(disease.isPresent());
    }
}