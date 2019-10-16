package com.hospital.controller.dto;

import com.hospital.controller.model.Department;

public class DepartmentDTO {

    public Long id;
    public String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sync(Department elt){
        id=elt.getId();
        name=elt.getDepartmentName();
    }
}
