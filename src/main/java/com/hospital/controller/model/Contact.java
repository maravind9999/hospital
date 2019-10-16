package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance
public abstract class Contact {

    @Id
    @GeneratedValue
    public Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "contact_Number")
    private Integer contactNumber;
    @Column(name = "Description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
