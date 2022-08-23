package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue
    Integer id;

    public String project;

    @ManyToOne
    Professor professor;
}
