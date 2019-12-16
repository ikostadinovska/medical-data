package com.better.model.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "department",
        "patients"
})
@XmlRootElement(name = "doctor")
public class Doctor {

    @XmlAttribute(name="id")
    private Long id;
    @XmlAttribute(name="department")
    private String department;

    @XmlElementWrapper(name="patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;
}
