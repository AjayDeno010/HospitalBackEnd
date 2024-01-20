package com.medicalAppointment.service;

import com.medicalAppointment.dto.AvailabilityDto;
import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
  DoctorDto createDoctor(DoctorDto DoctorDto);
  DoctorDto getDoctor(Long doctorId);
  List<DoctorDto> getAllDoctor();
  List<DoctorDto> checkAvailability(AvailabilityDto availabilityDto);


}
