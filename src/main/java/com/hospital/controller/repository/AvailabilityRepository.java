package com.hospital.controller.repository;

import com.hospital.controller.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    Availability findAvailabilityByDoctorIdAndMonthAndYear(Long id, Integer month, Integer year);
}
