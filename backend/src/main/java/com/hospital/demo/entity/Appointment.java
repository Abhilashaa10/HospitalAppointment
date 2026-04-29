    package com.hospital.demo.entity;

    import java.time.LocalDateTime;

    import com.fasterxml.jackson.annotation.JsonFormat;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;

    @Entity
    public class Appointment {
        
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        
        private long id;
        private String patientName;
        private  String doctorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

        private String status;

        public Appointment(){ } // default constructor 

        public long getId() {
            return id;
        }

        public void setId(long id) {
        this.id = id;
    }


        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getDoctorName() {
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

        

