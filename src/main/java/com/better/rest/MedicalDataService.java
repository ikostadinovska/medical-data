package com.better.rest;

import com.better.model.dto.Doctor;
import com.better.model.dto.DocumentReport;
import com.better.model.dto.Patient;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Tag(name = "Medical Data Service",
        description = "Medical data service processes input data for the doctor and patients.")
public interface MedicalDataService {

    @PostMapping(value = "/v1/add-document",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<DocumentReport> addDocument(@RequestBody Doctor doctor);

    @GetMapping(value = "/v1/doctors",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<List<Doctor>> listDoctors();

    @GetMapping(value = "/v1/doctors/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<Doctor> getDoctorDetails(@PathVariable("id") @NotNull Long id);

    @GetMapping(value = "/v1/doctors/{id}/patients",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<List<Patient>> listPatientsForDoctor(@PathVariable("id") @NotNull Long id);

    @GetMapping(value = "/v1/doctors/{id}/patients/{patient-id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<Patient> getPatientDetails(@PathVariable("id") @NotNull Long id,
                                                  @PathVariable("patient-id") @NotNull Long patientId);

    @GetMapping(value = "/v1/doctors/{id}/patients/{patient-id}/diseases",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<List<String>> listPatientDiseases(@PathVariable("id") @NotNull Long id,
                                                     @PathVariable("patient-id") @NotNull Long patientId);
}
