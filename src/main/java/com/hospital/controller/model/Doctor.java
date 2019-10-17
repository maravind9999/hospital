package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor extends Contact {


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

  /*  @OneToOne(mappedBy = "doctor")
    private Appointment appointment;*/

    @OneToMany(mappedBy="doctor")
    private Set<Availability> availabilities;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

   /* public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }*/

    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }

}
