package com.medicalAppointment.dto;

import com.medicalAppointment.entity.DoctorEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntityResponse {

    private Long appointmentId;
    private Long userId;
    private Long doctorId;

    private DoctorEntity doctorEntity;
    private String patientName;
    private Time appointmentTime;
    private Date appointmentDate;
    private List<String> prescribedMedicine;
    private String location;
    private String phoneNumber;
    private String address;
    private String requiredDoctorSpecialisation;
    private List<DoctorEntity> availableDoctors;


    private String email;
}
