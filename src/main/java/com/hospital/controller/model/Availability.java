package com.hospital.controller.model;

import javax.persistence.*;


@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_Id")
    private Long availabilityId;


    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;


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
