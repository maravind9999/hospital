package com.hospital.controller.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_Id")
    private Long availabilityId;

    @Column(name = "date")
    private Date date;

    @Column(name = "year")
    private Year year;

    @Column(name = "month")
    private Month month;


    @OneToOne(mappedBy = "availability")
    private Doctor doctor;

    @OneToOne(mappedBy = "availability")
    private Appointment appointment;

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }



    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
