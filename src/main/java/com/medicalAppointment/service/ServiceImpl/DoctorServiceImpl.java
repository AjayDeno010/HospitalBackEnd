package com.medicalAppointment.service.ServiceImpl;

import com.medicalAppointment.dto.AvailabilityDto;
import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.entity.DoctorEntity;
import com.medicalAppointment.repository.DoctorRepository;
import com.medicalAppointment.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private ModelMapper modelMapper;


    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
    DoctorEntity doctorEntity=  modelMapper.map(doctorDto,DoctorEntity.class);
   DoctorEntity doctor= doctorRepository.save(doctorEntity);
        return modelMapper.map(doctor,DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctor(Long doctorId) {

      DoctorEntity doctorDto=  doctorRepository.findById(doctorId).get();
        return modelMapper.map(doctorDto,DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        return doctorRepository.findAll().stream().map((dtos)->modelMapper.map(dtos,DoctorDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> checkAvailability(AvailabilityDto availabilityDto) {
    List<DoctorEntity> availability= doctorRepository.findByDoctorSpecialisation(availabilityDto.getRequiredDoctorSpecialisation());
        return Collections.singletonList(modelMapper.map(availability, DoctorDto.class));
    }


}
