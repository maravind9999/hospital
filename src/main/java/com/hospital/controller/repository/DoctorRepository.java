package com.hospital.controller.repository;

import com.hospital.controller.model.Availability;
import com.hospital.controller.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   List<Doctor> findDoctorsByDepartmentId(Long id);

}
