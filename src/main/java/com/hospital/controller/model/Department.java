package com.hospital.controller.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_Id")
    private Long departmentId;

    @Column(name = "department_Name")
    private String departmentName;


    @ManyToOne
    @JoinColumn(name = "service_Id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "appointment_Id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "contact_Id")
    private Contact contact;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
