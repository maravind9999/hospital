package com.hospital.controller.services;

import com.hospital.controller.model.Appointment;
import com.hospital.controller.model.Department;
import com.hospital.controller.repository.AppointmentRepository;
import com.hospital.controller.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalService {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping(value = "/getDepartment")
    public List<Department>  getAll(){
        return departmentRepository.findAll();
    }

    @PostMapping(value = "/load")
    public Appointment load(@RequestBody final Appointment appointment ){
        return  appointmentRepository.save(appointment);
    }

}
