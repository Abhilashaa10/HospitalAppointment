package com.hospital.demo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Appointment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int id;
    private String patientName;
    private  String doctorName;
    private LocalDateTime appointmentTime;
    private String status;

     public int getId() {
        return id;
    }

    public String getpatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getdoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

    

