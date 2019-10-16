package com.hospital.controller.services;

import com.hospital.controller.dto.AvailableDTO;
import com.hospital.controller.dto.DepartmentDTO;
import com.hospital.controller.dto.DoctoreDTO;
import com.hospital.controller.dtoHelper.DtoHelper;
import com.hospital.controller.model.Appointment;
import com.hospital.controller.model.Availability;
import com.hospital.controller.model.Doctor;
import com.hospital.controller.repository.AppointmentRepository;
import com.hospital.controller.repository.AvailabilityRepository;
import com.hospital.controller.repository.ContactRepository;
import com.hospital.controller.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/hospital")
public class HospitalService {

    DtoHelper dtoHelper = new DtoHelper();
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public ContactRepository<Doctor> doctorRepository;

    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public AvailabilityRepository availabilityRepository;


    @GetMapping(value = "/getDepartments")
    public List<DepartmentDTO>  getDepartments(){
        List<DepartmentDTO> depList = new ArrayList<>();
        departmentRepository.findAll().forEach(elt->{
            DepartmentDTO dto = new DepartmentDTO();
            dto.sync(elt);
            depList.add(dto);
        });return depList;
    }
    @GetMapping(value = "/getDoctorsByDepId/{id}")
    public List<DoctoreDTO> getDoctorsByDepId(@PathVariable("id") Long id){
        List<DoctoreDTO> docList = new ArrayList<>();
       doctorRepository.findDoctorsByDepartmentId(id).forEach(elt->{
           DoctoreDTO dto=new DoctoreDTO();
           dto.sync(elt);
           docList.add(dto);
       });
       return docList;
    }

    @GetMapping(value = "/getAvailableTimeByDocIdAndMonthAndYear/{id}/{month}/{year}")
    public AvailableDTO getAvailableTimeByDocIdAndMonthAndYear(@PathVariable Long id, @PathVariable Integer month, @PathVariable Integer year) {
        Availability ava = availabilityRepository.findAvailabilityByDoctorIdAndMonthAndYear(id,month,year);
        AvailableDTO dto = new AvailableDTO();
        dto.sync(ava);
        return dto;
    }

    @PostMapping(value = "/creatData")
    public List<Appointment> load(@RequestBody Appointment appointment){
        appointmentRepository.save(appointment);
        return appointmentRepository.findAll();
    }

}
