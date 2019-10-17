package com.hospital.controller.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_Id")
    public Long id;

    @Column(name = "department_Name")
    public String departmentName;

    /*@OneToOne(mappedBy = "department")
    private Appointment appointment;*/

   @OneToMany(mappedBy="department")
    private Set<Doctor> doctors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

  /*  public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }*/

   public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
