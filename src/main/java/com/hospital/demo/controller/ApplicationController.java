package com.hospital.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.demo.Entity.Appointment;
import com.hospital.demo.repository.AppointmentRepository;


@RestController
public class ApplicationController{

    private final AppointmentRepository repository;

    public ApplicationController(AppointmentRepository repository) {
    this.repository = repository;
}

    @GetMapping("/appointments/save-test")
    public String saveTest(){
        Appointment a = new Appointment();
        a.setPatientName("rowan");
        a.setDoctorName("james");
        a.setStatus("booked");

        repository.save(a);

        return "Saved!";
        }
}