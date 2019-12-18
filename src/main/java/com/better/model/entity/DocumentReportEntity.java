package com.better.model.entity;

import com.better.model.enums.DocumentSource;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "document_report")
public class DocumentReportEntity {
    private Long id;
    private Boolean error;
    private String errorMsg;
    private DocumentSource source;
    private LocalDateTime executionTime;
    private DoctorEntity doctorByDoctorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "error")
    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    @Basic
    @Column(name = "error_msg")
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Basic
    @Column(name = "source")
    public DocumentSource getSource() {
        return source;
    }

    public void setSource(DocumentSource source) {
        this.source = source;
    }

    @Basic
    @Column(name = "execution_time")
    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentReportEntity that = (DocumentReportEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(error, that.error) &&
                Objects.equals(errorMsg, that.errorMsg) &&
                Objects.equals(source, that.source) &&
                Objects.equals(executionTime, that.executionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, error, errorMsg, source, executionTime);
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    public DoctorEntity getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(DoctorEntity doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }

    @PrePersist
    public void setExecutionTime() {
        setExecutionTime(LocalDateTime.now());
    }
}
