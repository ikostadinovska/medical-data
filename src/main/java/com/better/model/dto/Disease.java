package com.better.model.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "name"
})
@XmlRootElement(name = "disease")
public class Disease {

    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "name")
    private String name;
}