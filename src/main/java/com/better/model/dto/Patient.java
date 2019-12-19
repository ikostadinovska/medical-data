package com.better.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "firstName",
        "lastName",
        "diseases"
})
@XmlRootElement(name = "patient")
public class Patient {

    @NotNull
    @XmlElement(name = "id")
    private Long id;

    @NotBlank
    @XmlElement(name = "first_name")
    private String firstName;

    @NotBlank
    @XmlElement(name = "last_name")
    private String lastName;

    @NotEmpty
    @XmlElementWrapper(name = "diseases")
    @XmlElement(name = "disease")
    private List<String> diseases;
}
