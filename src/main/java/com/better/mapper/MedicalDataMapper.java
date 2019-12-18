package com.better.mapper;

import com.better.model.dto.Doctor;
import com.better.model.dto.DocumentReport;
import com.better.model.dto.Patient;
import com.better.model.entity.DiseaseEntity;
import com.better.model.entity.DoctorEntity;
import com.better.model.entity.DocumentReportEntity;
import com.better.model.entity.PatientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MedicalDataMapper {

    DiseaseEntity mapToDiseaseEntity(String diseaseName);

    @Mapping(source = "diseases", target = "diseasesById")
    PatientEntity mapToPatientEntity(Patient patient);

    @InheritInverseConfiguration
    @Mapping(source = "diseasesById", target = "diseases", qualifiedByName = "mapToDiseaseList")
    Patient mapToPatient(PatientEntity entity);

    List<Patient> mapToPatientList(List<PatientEntity> patientEntities);

    @Mapping(source = "patients", target = "patientsById")
    DoctorEntity mapToDoctorEntity(Doctor doctor);

    @InheritInverseConfiguration
    Doctor mapToDoctor(DoctorEntity doctorEntity);

    List<Doctor> mapToDoctorList(List<DoctorEntity> doctorEntityList);

    @Mapping(source = "doctorByDoctorId", target = "doctor")
    DocumentReport mapToDocumentReport(DocumentReportEntity documentReportEntity);

    @Named("mapToDiseaseList")
    default List<String> mapToDiseaseList(Collection<DiseaseEntity> diseaseEntityList) {
        return diseaseEntityList.stream().map(DiseaseEntity::getDiseaseName).collect(Collectors.toList());
    }
}
