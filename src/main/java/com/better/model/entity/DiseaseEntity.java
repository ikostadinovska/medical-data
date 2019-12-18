package com.better.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disease")
public class DiseaseEntity {
    private Long id;
    private String diseaseName;
    private PatientEntity patientByPatientId;

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
    @Column(name = "disease_name")
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiseaseEntity that = (DiseaseEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(diseaseName, that.diseaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diseaseName);
    }

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    public PatientEntity getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(PatientEntity patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }
}
