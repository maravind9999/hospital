package com.hospital.controller.repository;

import com.hospital.controller.model.Contact;
import com.hospital.controller.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository<T extends Contact> extends JpaRepository<Contact, Long> {

    List<Doctor> findDoctorsByDepartmentId(Long id);


}
