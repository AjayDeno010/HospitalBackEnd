package com.medicalAppointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrescribedMedicineDto {
    private Long appointmentId;
    private Long userId;
    private List<String> prescribedMedicine;
}
