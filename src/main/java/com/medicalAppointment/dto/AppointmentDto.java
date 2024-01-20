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
public class AppointmentDto {
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

    private List<DoctorDto> availableDoctors;
    private String email;
//    @Id
//    @GeneratedValue
//    private Long appointmentId;
//    private Long userId;
//    private Long doctorId;
//    @ManyToOne
//    private DoctorEntity doctorEntity;
//    private String patientName;
//    private Time appointmentTime;
//    private Date appointmentDate;
//    private List<String> prescribedMedicine;
//    private String location;
//    private String phoneNumber;
//    private String address;
//    private String requiredDoctorSpecialisation;
//
//    // Use @OneToMany for a list of available doctors
//    @OneToMany
//    private List<DoctorEntity> availableDoctors;
//
//
//    private String email;
}
