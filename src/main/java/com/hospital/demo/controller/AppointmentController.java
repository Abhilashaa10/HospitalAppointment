package com.hospital.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.demo.dto.AppointmentDTO;
import com.hospital.demo.service.AppointmentService;


@CrossOrigin(origins = "*")
@RestController
public class AppointmentController {

    private final AppointmentService service; //http mthd

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

@PostMapping("/appointments")
public List<AppointmentDTO> createAppointment(@RequestBody List<@Valid AppointmentDTO> appointments) {
    return appointments.stream()
            .map(service::saveAppointment)
            .collect(java.util.stream.Collectors.toList());
}

@GetMapping("/appointments")
public List<AppointmentDTO> getAllAppointments() {
    return service.getAllAppointments();
}

@GetMapping("/appointments/{id}")
public AppointmentDTO getById(@PathVariable Long id) {
    return service.getAppointmentById(id);
}

@PutMapping("/appointments/{id}")
public AppointmentDTO updateAppointment(@PathVariable Long id,
                                        @RequestBody @Valid AppointmentDTO appointmentDTO) {
    return service.updateAppointment(id, appointmentDTO);
}

@DeleteMapping("/appointments/{id}")
public String deleteAppointment(@PathVariable Long id){
    service.deleteAppointment(id);
    return "Apppointment deleted successfully";
}

@GetMapping("/appointments/save-test")
public String saveTest() {

    AppointmentDTO a = new AppointmentDTO();
    a.setPatientName("Rahul");
    a.setDoctorName("Dr. Sharma");
    a.setAppointmentTime(LocalDateTime.parse("2026-04-23T18:30:00"));

    service.saveAppointment(a);

    return "Saved via Service!";
}
}