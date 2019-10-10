package com.hospital.controller.repository;

import com.hospital.controller.model.Department;
import com.hospital.controller.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentRepository extends JpaRepository<Department, Long> {

                 Department findDepartmentById(Long id);
              //Department findByDepartmentId(Long id);
}
