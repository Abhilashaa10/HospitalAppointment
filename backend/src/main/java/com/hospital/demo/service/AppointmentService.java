package com.hospital.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.demo.dto.AppointmentDTO;
import com.hospital.demo.entity.Appointment;
import com.hospital.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {

    Appointment appointment = mapToEntity(appointmentDTO);

    appointment.setStatus("BOOKED");

    Appointment savedAppointment = repository.save(appointment);

    return mapToDTO(savedAppointment);
}

    public List<AppointmentDTO> getAllAppointments() {
    return repository.findAll()
            .stream()
            .map(this::mapToDTO)
            .toList();
}

    public AppointmentDTO getAppointmentById(Long id) {
    Appointment appointment = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found"));

    return mapToDTO(appointment);
}

   public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {

    Appointment existingAppointment = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found"));

    existingAppointment.setPatientName(appointmentDTO.getPatientName());
    existingAppointment.setDoctorName(appointmentDTO.getDoctorName());
    existingAppointment.setAppointmentTime(appointmentDTO.getAppointmentTime());

    Appointment updatedAppointment = repository.save(existingAppointment);

    return mapToDTO(updatedAppointment);
}

public void deleteAppointment(Long id){
    Appointment appointment = repository.findById(id)
    .orElseThrow(() -> new RuntimeException("appointment not found"));

    repository.delete(appointment);
}

private Appointment mapToEntity(AppointmentDTO dto) {  //DTO → Entity  - Used when request comes in.
    Appointment appointment = new Appointment();
    // appointment.setId(dto.getId());
    appointment.setPatientName(dto.getPatientName());
    appointment.setDoctorName(dto.getDoctorName());
    appointment.setAppointmentTime(dto.getAppointmentTime());
    appointment.setStatus(dto.getStatus());
    return appointment;
}

private AppointmentDTO mapToDTO(Appointment appointment) { //Entity → DTO - Used when response goes out.
    AppointmentDTO dto = new AppointmentDTO();
    dto.setId(appointment.getId());
    dto.setPatientName(appointment.getPatientName());
    dto.setDoctorName(appointment.getDoctorName());
    dto.setAppointmentTime(appointment.getAppointmentTime());
    dto.setStatus(appointment.getStatus());
    return dto;
}
}