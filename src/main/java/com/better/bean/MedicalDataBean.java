package com.better.bean;

import com.better.mapper.MedicalDataMapper;
import com.better.model.dto.Doctor;
import com.better.model.dto.DocumentReport;
import com.better.model.dto.Patient;
import com.better.model.entity.DoctorEntity;
import com.better.model.entity.DocumentReportEntity;
import com.better.model.entity.PatientEntity;
import com.better.model.enums.DocumentSource;
import com.better.repositories.DiseaseRepository;
import com.better.repositories.DoctorRepository;
import com.better.repositories.DocumentReportRepository;
import com.better.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class MedicalDataBean {

    @Autowired
    private MedicalDataMapper mapper;

    @Autowired
    private DocumentReportRepository documentReportRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    /**
     * Create document report.
     *
     * @param doctor
     * @param documentSource
     * @return
     */
    public DocumentReport createReport(Doctor doctor, DocumentSource documentSource) {

        DoctorEntity doctorEntity = mapper.mapToDoctorEntity(doctor);
        doctorEntity.getPatientsById().forEach(p -> p.setDoctorByDoctorId(doctorEntity));
        doctorEntity.getPatientsById().forEach(p -> p.getDiseasesById().forEach(d -> d.setPatientByPatientId(p)));
        doctorRepository.save(doctorEntity);

        DocumentReportEntity documentReportEntity = new DocumentReportEntity();
        documentReportEntity.setDoctorByDoctorId(doctorEntity);
        documentReportEntity.setSource(documentSource);
        documentReportRepository.save(documentReportEntity);

        return mapper.mapToDocumentReport(documentReportEntity);
    }

    public List<Doctor> listDoctors() {
        return mapper.mapToDoctorList(doctorRepository.findAll());
    }

    public Doctor getDoctorDetails(Long id) {
        Optional<DoctorEntity> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return mapper.mapToDoctor(doctor.get());
        }
        return null;
    }

    public List<Patient> listPatientsForDoctor(Long id) {
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(id);
        if (doctorEntity.isPresent()) {
            return mapper.mapToPatientList(patientRepository.findAllByDoctorByDoctorId(doctorEntity.get()));
        }
        return Collections.emptyList();
    }

    public Patient getPatientDetails(Long id, Long patientId) {
        Optional<PatientEntity> patientEntity = patientRepository.findById(patientId);
        if (patientEntity.isPresent()) {
            return mapper.mapToPatient(patientEntity.get());
        }
        return null;
    }

    public List<String> listPatientDiseases(Long id, Long patientId) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        return mapper.mapToDiseaseList(diseaseRepository.findAllByPatientByPatientId(patientEntity));
    }

}
