package com.medicalAppointment.service.ServiceImpl;

import com.medicalAppointment.Exception.NoDoctorsAvailableException;
import com.medicalAppointment.dto.AppointmentDto;
import com.medicalAppointment.dto.AvailabilityDto;
import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.dto.PrescribedMedicineDto;
import com.medicalAppointment.entity.AppointmentEntity;
import com.medicalAppointment.entity.DoctorEntity;
import com.medicalAppointment.repository.AppointmentRepository;
import com.medicalAppointment.repository.DoctorRepository;
import com.medicalAppointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;
    private ModelMapper modelMapper;
@Override
public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
    List<DoctorEntity> doctors = doctorRepository.findByDoctorSpecialisation(appointmentDto.getRequiredDoctorSpecialisation());

    List<DoctorDto> changed = new ArrayList<>();
    for (DoctorEntity doctor : doctors) {
        changed.add(modelMapper.map(doctor, DoctorDto.class));
    }

    appointmentDto.setAvailableDoctors(changed);
    // appointmentDto.setDoctorId(appointmentDto.getDoctorEntity().getDoctorId());

    AppointmentEntity appointmentEntity = modelMapper.map(appointmentDto, AppointmentEntity.class);
    AppointmentEntity saved = appointmentRepository.save(appointmentEntity);
    if (saved.getAvailableDoctors()==null|| saved.getAvailableDoctors().isEmpty()){
        throw new NoDoctorsAvailableException("No doctors available for the specified specialisation");
    }

    return modelMapper.map(saved, AppointmentDto.class);
}


    public List<PrescribedMedicineDto> viewPrescribedMedicine(Long userId) {
        List<AppointmentEntity> appointments = null;
        try {
            appointments = appointmentRepository.findByUserId(userId);
            // rest of the code
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            // Handle or rethrow the exception as needed
        }

        // Assuming AppointmentEntity has a method to getPrescribedMedicineList
        return appointments.stream()
                .map(appointment -> new PrescribedMedicineDto(
                        appointment.getAppointmentId(),
                        appointment.getUserId(),
                        appointment.getPrescribedMedicine()
                                .stream()
                                .limit(3) // Limit to three values
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentEntity> getAppointmentHistory(Long userId) {
   List<AppointmentEntity> appointmentEntities= appointmentRepository.findByUserId(userId);
        return appointmentEntities;
    }


}
