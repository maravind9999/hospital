package com.hospital.controller.handler;

import com.hospital.controller.dto.AppointmentDTO;
import com.hospital.controller.model.Appointment;
import com.hospital.controller.model.Patient;
import com.hospital.controller.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Handler {

    @Autowired
    AppointmentRepository appointmentRepository;

    public Appointment getApp(AppointmentDTO appointmentDTO){
        Appointment app = new Appointment();
        Patient pa= new Patient();
        app.depId=appointmentDTO.depId;
        app.docId=appointmentDTO.docId;
        app.date=appointmentDTO.appDate;
        pa.age=appointmentDTO.age;
        pa.firstName=appointmentDTO.firstName;
        pa.lastName=appointmentDTO.LastName;
        pa.contactNumber=appointmentDTO.contactNumber;
        pa.description=appointmentDTO.desc;
        app.patient = pa;
        appointmentRepository.save(app);
        return app;
    }
}
