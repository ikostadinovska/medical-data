package com.better.rest.impl;

import com.better.model.dto.Doctor;
import com.better.rest.MedicalDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */

@RestController
public class MedicalDataServiceImpl implements MedicalDataService {

    @Override
    public ResponseEntity addDocument(Doctor doctor) {
        return null;
    }
}

