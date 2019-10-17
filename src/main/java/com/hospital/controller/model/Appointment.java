package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "dep_Id")
    public Integer depId;

    @Column(name = "docId")
    public Integer docId;

    @Column(name = "date")
    public Date date;

   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient")
    public Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }
}