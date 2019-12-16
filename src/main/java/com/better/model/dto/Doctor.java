package com.better.model.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Data
public class Doctor {
    private Long id;
    private String department;

    private List<Patient> patients;
}
