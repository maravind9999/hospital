package com.hospital.controller.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue
    @Column(name = "service_Id")
    private Long serviceId;

    @Column(name = "service_Name")
    private String serviceName;

    @OneToMany(targetEntity = Department.class, mappedBy = "service", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Department> departments;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
