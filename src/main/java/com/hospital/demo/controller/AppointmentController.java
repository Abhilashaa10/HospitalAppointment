package com.hospital.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.demo.entity.Appointment;
import com.hospital.demo.service.AppointmentService;



@RestController
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

@PostMapping("/appointments")
public List<Appointment> createAppointment(@RequestBody List<Appointment> appointments) {
    return appointments.stream()
    .map(service::saveAppointment)
.collect(java.util.stream.Collectors.toList());}

@GetMapping("/appointments")
public List<Appointment> getAllAppointments() {
    return service.getAllAppointments();
}

@GetMapping("/appointments/{id}")
public Appointment getById(@PathVariable Long id) {
    return service.getAppointmentById(id);
}

@PutMapping("/appointments")
public List<Appointment> updateAppointments(@RequestBody List<Appointment> appointments) {
    return appointments.stream()
            .map(appointment -> service.updateAppointment(appointment.getId(), appointment))
            .toList();
}


@DeleteMapping("/appointments/{id}")
public String deleteAppointment(@PathVariable Long id){
    service.deleteAppointment(id);
    return "Apppointment deleted successfully";
}

@GetMapping("/appointments/save-test")
    public String saveTest() {

        Appointment a = new Appointment();
        a.setPatientName("Rahul");
        a.setDoctorName("Dr. Sharma");
        a.setAppointmentTime(LocalDateTime.parse("2026-04-23T18:30:00"));

        service.saveAppointment(a);

        return "Saved via Service!";
    }
}