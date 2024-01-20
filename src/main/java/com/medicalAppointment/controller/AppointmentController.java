package com.medicalAppointment.controller;

import com.medicalAppointment.dto.AppointmentDto;
import com.medicalAppointment.dto.PrescribedMedicineDto;
import com.medicalAppointment.entity.AppointmentEntity;
import com.medicalAppointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
@AllArgsConstructor
public class AppointmentController {
    private AppointmentService appointmentService;
    @PostMapping("create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
       AppointmentDto appointmentDto1= appointmentService.createAppointment(appointmentDto);
       return new ResponseEntity<>(appointmentDto1, HttpStatus.CREATED);
    }
    @GetMapping("{userId}/getPrescribedMedicine")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<PrescribedMedicineDto>> getPrescribedMedicine(@PathVariable Long userId){
       List<PrescribedMedicineDto> list= appointmentService.viewPrescribedMedicine(userId);
       return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("{userId}/getAppointmentHistory")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<AppointmentEntity>> getAppointmentHistory(@PathVariable Long userId){
       List<AppointmentEntity> entities= appointmentService.getAppointmentHistory(userId);
       return new ResponseEntity<>(entities,HttpStatus.OK);
    }
}
