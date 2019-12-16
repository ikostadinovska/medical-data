package com.better.rest;

import com.better.model.dto.Doctor;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
public interface MedicalDataService {

    @ApiOperation(value = "Add new document.", notes = "Method adds new document.")
    @PostMapping(value = "/v1/add-document",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    ResponseEntity addDocument(@RequestBody Doctor doctor);
}
