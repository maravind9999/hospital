package com.hospital.controller.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_Id")
    private Long availabilityId;

    @Column(name = "time_From")
    private Time  timeFrom;

    @Column(name = "time_To")
    private Time timeTo;


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

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
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
