package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "contact_Id")
    private Long contactId;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "phone_Number")
    private Integer phoneNumber;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "availability_Id")
    private Availability availability;

    @ManyToOne
    @JoinColumn(name = "appointment_Id ")
    private Appointment appointment;

    @OneToMany(targetEntity = Department.class, mappedBy = "contact", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Department> departments;

    public Long getConId() {
        return contactId;
    }

    public void setConId(Long conId) {
        this.contactId = conId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
