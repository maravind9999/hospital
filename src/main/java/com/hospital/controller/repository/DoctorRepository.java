package com.hospital.controller.repository;

import com.hospital.controller.model.Department;
import com.hospital.controller.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.alps.Doc;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   Doctor findDoctorByDoctorId(Long id);

}
