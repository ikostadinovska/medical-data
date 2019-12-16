package com.better.model.dao;

import javax.persistence.*;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */

@Entity
@Table(name = "DISEASE")

public class DiseaseEntity {

    private Long id;
    private String name;

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
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }
}
