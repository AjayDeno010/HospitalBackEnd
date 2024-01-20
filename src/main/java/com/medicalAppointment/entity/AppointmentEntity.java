package com.medicalAppointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AppointmentEntity {
    @Id
    @GeneratedValue
    private Long appointmentId;
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctorEntity;

    private String patientName;
    private Time appointmentTime;
    private Date appointmentDate;
    private List<String> prescribedMedicine;
    private String location;
    private String phoneNumber;
    private String address;
    private String requiredDoctorSpecialisation;

    @ManyToMany
    @JoinTable(
            name = "appointment_doctor",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<DoctorEntity> availableDoctors;

    private String email;
}


