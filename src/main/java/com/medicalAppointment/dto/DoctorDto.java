package com.medicalAppointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medicalAppointment.entity.AppointmentEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long doctorId;
    private String doctorName;
    private String doctorSpecialisation;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fromDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date toDate;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Time fromTime;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Time toTime;
    private String experience;
    private List<AppointmentEntity> appointments;
}
