package com.better.model.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Ivana Kostadinovska on 16-Dec-19.
 */
@Data
public class Patient {
    private Long id;
    private String first_name;
    private String last_name;

    private List<Disease> diseases;
}
