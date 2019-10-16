package com.hospital.controller;

import com.hospital.controller.dto.DepartmentDTO;
import com.hospital.controller.model.Department;
import com.hospital.controller.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControllerApplication {

    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
       // ControllerApplication  cp = new ControllerApplication();
      //  cp.loadData();
    }

  /*  public void loadData(){
        Department dep = new Department();
        dep.setId(1l);
        dep.setDepartmentName("neurology");
        departmentRepository.save(dep);
        Department dep1 = new Department();
        dep1.id = 2l;
        dep1.departmentName = "gynecologist";
        departmentRepository.save(dep1);
        Department dep2 = new Department();
        dep2.id = 3l;
        dep2.departmentName = "haematology";
        departmentRepository.save(dep2);


    }
*/

}
