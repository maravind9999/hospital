package com.hospital.controller.model;

import javax.persistence.*;

@Entity
public class Patient extends Contact {

    @Column(name = "age")
    public Integer age;

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
