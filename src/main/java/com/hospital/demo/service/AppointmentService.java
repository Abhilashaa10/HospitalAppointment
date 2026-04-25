package com.hospital.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.hospital.demo.entity.Appointment;
import com.hospital.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment saveAppointment(Appointment appointment) {
        appointment.setStatus("BOOKED");
        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Appointment getAppointmentById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment){
        Appointment existingAppointment = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found"));

        existingAppointment.setPatientName(updatedAppointment.getPatientName());
        existingAppointment.setDoctorName(updatedAppointment.getDoctorName());
        existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        
return repository.save(existingAppointment);

}

public void deleteAppointment(Long id){
    Appointment appointment = repository.findById(id)
    .orElseThrow(() -> new RuntimeException("appointment not found"));

    repository.delete(appointment);
}
}