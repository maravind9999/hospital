package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor extends Contact {


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToMany(mappedBy="doctor")
    private Set<Availability> availabilities;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }

}
