package com.medicalAppointment.service;

import com.medicalAppointment.dto.AppointmentDto;
import com.medicalAppointment.dto.AvailabilityDto;
import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.dto.PrescribedMedicineDto;
import com.medicalAppointment.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentService {
  AppointmentDto  createAppointment(AppointmentDto appointmentDto);

    List<PrescribedMedicineDto> viewPrescribedMedicine(Long userId);

  List<AppointmentEntity> getAppointmentHistory(Long userId);
}
