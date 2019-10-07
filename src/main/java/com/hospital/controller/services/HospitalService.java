package com.hospital.controller.services;

import com.hospital.controller.model.Availability;
import com.hospital.controller.model.Department;
import com.hospital.controller.model.Doctor;
import com.hospital.controller.repository.DepartmentRepository;
import com.hospital.controller.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalService {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public DoctorRepository doctorRepository;


    @GetMapping(value = "/getDepartments")
    public List<Department>  getAll(){
        return departmentRepository.findAll();
    }

    @GetMapping(value = "/docById{id}")
    public Set<Doctor> getDoc(@PathVariable Long id){
        return departmentRepository.findDepartmentById(id).getDoctors();
    }

    @GetMapping(value = "/avaByDocId{id}")
    public Availability getAva(@PathVariable Long id){
        return doctorRepository.findDoctorsByDoctorId(id).getAvailability();
    }


}
