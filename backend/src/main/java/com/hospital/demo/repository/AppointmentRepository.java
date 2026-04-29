package com.hospital.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.demo.entity.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}