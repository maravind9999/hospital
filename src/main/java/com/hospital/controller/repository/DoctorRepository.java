package com.hospital.controller.repository;

import com.hospital.controller.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   Doctor findDoctorByDoctorId(Long id);

}
