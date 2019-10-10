package com.hospital.controller.services;

import com.hospital.controller.dto.AvailableDTO;
import com.hospital.controller.dto.DepartmentDTO;
import com.hospital.controller.dto.DoctoreDTO;
import com.hospital.controller.model.Appointment;
import com.hospital.controller.model.Availability;
import com.hospital.controller.model.Department;
import com.hospital.controller.model.Doctor;
import com.hospital.controller.repository.AppointmentRepository;
import com.hospital.controller.repository.AvailabilityRepository;
import com.hospital.controller.repository.DepartmentRepository;
import com.hospital.controller.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalService {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public AvailabilityRepository availabilityRepository;


    @GetMapping(value = "/getDepartments")
    public List<DepartmentDTO>  getAll(){
        List<DepartmentDTO> depList = new ArrayList<>();
        departmentRepository.findAll().forEach(elt->{
            DepartmentDTO dto = new DepartmentDTO();
            dto.id=elt.getId();
            dto.name=elt.getDepartmentName();
            depList.add(dto);
        });return depList;
    }
    @GetMapping(value = "/{id}")
    public List<DoctoreDTO> getDep(@PathVariable("id") Long id){
        List<DoctoreDTO> docList = new ArrayList<>();
       Department dep = departmentRepository.findDepartmentById(id);
          dep.getDoctors().forEach(elt->{
           DoctoreDTO dto=new DoctoreDTO();
           dto.id=elt.getDoctorId();
           dto.name=elt.getFirstName();
           docList.add(dto);
       });
       return docList;
    }

    @GetMapping(value = "/aviById/{id}")
    public AvailableDTO getAva(@PathVariable("id") Long id) {
        Availability ava= doctorRepository.findDoctorByDoctorId(id).getAvailability();
        AvailableDTO dto = new AvailableDTO();
        dto.id=ava.getAvailabilityId();
        return dto;
    }
}
