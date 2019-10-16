package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient extends Contact {

    @Column(name = "dateOfBirth")
    private Date dob;

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
