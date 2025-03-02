package com.hospital.controller.model;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class Contact {

    @Id
    @GeneratedValue
    public Long id;
    @Column(name = "first_Name")
    public String firstName;
    @Column(name = "last_Name")
    public String lastName;
    @Column(name = "contact_Number")
    public Long contactNumber;
    @Column(name = "Description")
    public String description;

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

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
