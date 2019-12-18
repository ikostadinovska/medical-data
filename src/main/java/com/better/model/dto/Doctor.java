package com.better.model.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "department",
        "patients"
})
@XmlRootElement(name = "doctor")
public class Doctor {

    @NotNull
    @XmlAttribute(name="id")
    private Long id;

    @NotBlank
    @XmlAttribute(name="department")
    private String department;

    @Valid
    @NotEmpty
    @XmlElementWrapper(name="patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;
}
