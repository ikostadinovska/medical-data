package com.better.model.dao;

import javax.persistence.*;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */

@Entity
@Table(name = "PATIENT")

public class PatientEntity {

    private Long id;
    private String first_name;
    private String last_name;

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
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for property 'first_name'.
     *
     * @return Value for property 'first_name'.
     */
    @Basic
    @Column(name = "FIRST")
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter for property 'first_name'.
     *
     * @param first_name Value to set for property 'first_name'.
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter for property 'last_name'.
     *
     * @return Value for property 'last_name'.
     */
    @Basic
    @Column(name = "LAST")
    public String getLast_name() {
        return last_name;
    }

    /**
     * Setter for property 'last_name'.
     *
     * @param last_name Value to set for property 'last_name'.
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
