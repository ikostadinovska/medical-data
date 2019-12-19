package com.better.model.dto;

import com.better.model.enums.DocumentSource;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "error",
        "errorMsg",
        "source",
        "executionTime",
        "doctor"
})
@XmlRootElement(name = "document_report")
public class DocumentReport {

    @XmlAttribute(name="id")
    private Long id;
    @XmlAttribute(name="error")
    private Boolean error;
    @XmlAttribute(name="errorMsg")
    private String errorMsg;
    @XmlAttribute(name="source")
    private DocumentSource source;
    @XmlAttribute(name="executionTime")
    private LocalDateTime executionTime;
    @XmlAttribute(name="doctor")
    private Doctor doctor;
}
