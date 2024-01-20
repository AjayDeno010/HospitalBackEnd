package com.medicalAppointment.controller;

import com.medicalAppointment.dto.AvailabilityDto;
import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.dto.UserDto;
import com.medicalAppointment.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("doctor")
public class DoctorController {
    private DoctorService doctorService;
    @PostMapping("create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
    DoctorDto doctor=  doctorService.createDoctor(doctorDto);
    return new ResponseEntity<>(doctor,HttpStatus.CREATED);
    }
    @GetMapping("getAllDoctor")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
      List<DoctorDto> doctorDtos= doctorService.getAllDoctor();
      return new ResponseEntity<>(doctorDtos,HttpStatus.OK);
    }
    @GetMapping("{doctorID}/getDoctor")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long doctorID){
      DoctorDto dto=  doctorService.getDoctor(doctorID);
      return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("getDoctorBySpecialisation")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<DoctorDto>> getDoctorBySpecialisation(@RequestBody AvailabilityDto availabilityDto){
     List<DoctorDto> lists=   doctorService.checkAvailability(availabilityDto);
     return new ResponseEntity<>(lists,HttpStatus.OK);
    }
}
