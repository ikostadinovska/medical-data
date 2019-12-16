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
        "firstName",
        "lastName",
        "diseases"

})
@XmlRootElement(name = "patient")
public class Patient {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    private String lastName;

    @XmlElementWrapper(name = "diseases")
    @XmlElement(name = "disease")
    private List<Disease> diseases;
}
