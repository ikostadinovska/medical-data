package com.better.model.dao;

import javax.persistence.*;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */

@Entity
@Table(name = "DOCTOR")

public class DoctorEntity {

    private Long id;
    private String department;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Getter for property 'department'.
     *
     * @return Value for property 'department'.
     */
    @Basic
    @Column(name = "DEPARTMENT")
    public String getDepartment() {
        return department;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter for property 'department'.
     *
     * @param department Value to set for property 'department'.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
