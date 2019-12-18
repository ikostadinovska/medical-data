package com.better.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class PatientEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private Collection<DiseaseEntity> diseasesById;
    private DoctorEntity doctorByDoctorId;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @OneToMany(mappedBy = "patientByPatientId", cascade = CascadeType.ALL)
    public Collection<DiseaseEntity> getDiseasesById() {
        return diseasesById;
    }

    public void setDiseasesById(Collection<DiseaseEntity> diseasesById) {
        this.diseasesById = diseasesById;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    public DoctorEntity getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(DoctorEntity doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }
}
