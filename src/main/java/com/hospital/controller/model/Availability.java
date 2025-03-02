package com.hospital.controller.model;

import javax.persistence.*;


@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_Id")
    private Long availabilityId;

    @Column(name = "dates")
    private String dates;


    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;


    @ManyToOne
    @JoinColumn( name = "doctor_Id")
    private Doctor doctor;


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

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
