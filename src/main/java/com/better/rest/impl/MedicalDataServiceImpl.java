package com.better.rest.impl;

import com.better.bean.MedicalDataBean;
import com.better.model.dto.Doctor;
import com.better.model.dto.DocumentReport;
import com.better.model.dto.Patient;
import com.better.model.enums.DocumentSource;
import com.better.rest.MedicalDataService;
import com.better.util.FilesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */

@RestController
public class MedicalDataServiceImpl implements MedicalDataService {

    private static final Logger log = LoggerFactory.getLogger(FilesUtil.class);

    @Autowired
    private MedicalDataBean medicalDataBean;

    @Override
    public ResponseEntity<DocumentReport> addDocument(@Valid Doctor doctor) {
        DocumentReport documentReport = medicalDataBean.createReport(doctor, DocumentSource.HTTP_REQUEST);
        return ResponseEntity.ok(documentReport);
    }

    @Override
    public ResponseEntity<List<Doctor>> listDoctors() {
        List<Doctor> doctorList = medicalDataBean.listDoctors();
        if(!doctorList.isEmpty()) {
            return ResponseEntity.ok(doctorList);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Doctor> getDoctorDetails(@NotNull Long id) {
        Doctor doctor = medicalDataBean.getDoctorDetails(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Patient>> listPatientsForDoctor(@NotNull Long id) {
        List<Patient> patients = medicalDataBean.listPatientsForDoctor(id);
        if (!patients.isEmpty()) {
            return ResponseEntity.ok(patients);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Patient> getPatientDetails(@NotNull Long id, @NotNull Long patientId) {
        Patient patient = medicalDataBean.getPatientDetails(id, patientId);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<String>> listPatientDiseases(@NotNull Long id, @NotNull Long patientId) {
        List<String> diseases = medicalDataBean.listPatientDiseases(id, patientId);
        if (!diseases.isEmpty()) {
            return ResponseEntity.ok(diseases);
        }
        return ResponseEntity.notFound().build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        log.error("Bad request exception occurred.", ex);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> handleValidationExceptions(
            EntityNotFoundException ex) {
        log.error("Not Found exception occurred.", ex);
        Map<String, String> errors = new HashMap<>();
        errors.put("NOT_FOUND", "Entity not found.");
        return errors;
    }
}

