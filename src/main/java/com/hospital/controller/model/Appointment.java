package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "appointment_Id")
    private Long appointmentId;

    @Column(name = "date_Time")
    private Date dateTime;

    @Column(name = "comments")
    private String comments;

    @OneToMany(targetEntity = Department.class, mappedBy = "appointment", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Department> departments;

    @OneToMany(targetEntity = Contact.class, mappedBy = "appointment", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Contact> doctors;

    @OneToMany(targetEntity = Contact.class, mappedBy = "appointment", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Contact> patients;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Contact> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Contact> doctors) {
        this.doctors = doctors;
    }

    public Set<Contact> getPatients() {
        return patients;
    }

    public void setPatients(Set<Contact> patients) {
        this.patients = patients;
    }
}
