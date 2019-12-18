package com.better.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "doctor")
public class DoctorEntity {
    private long id;
    private String department;
    private Collection<DocumentReportEntity> documentReportsById;
    private Collection<PatientEntity> patientsById;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department);
    }

    @OneToMany(mappedBy = "doctorByDoctorId")
    public Collection<DocumentReportEntity> getDocumentReportsById() {
        return documentReportsById;
    }

    public void setDocumentReportsById(Collection<DocumentReportEntity> documentReportsById) {
        this.documentReportsById = documentReportsById;
    }

    @OneToMany(mappedBy = "doctorByDoctorId", cascade = CascadeType.ALL)
    public Collection<PatientEntity> getPatientsById() {
        return patientsById;
    }

    public void setPatientsById(Collection<PatientEntity> patientsById) {
        this.patientsById = patientsById;
    }
}
