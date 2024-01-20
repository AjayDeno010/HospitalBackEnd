package com.medicalAppointment.repository;

import com.medicalAppointment.dto.DoctorDto;
import com.medicalAppointment.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
   List<DoctorEntity> findByDoctorSpecialisation(String specialisation);
//@Query("SELECT new com.medicalAppointment.dto.DoctorDto(" +
//        "d.doctorId, d.doctorName, d.doctorSpecialisation, d.fromDate, d.toDate, d.fromTime, d.toTime, d.experience, d.appointments) " +
//        "FROM DoctorEntity d WHERE d.doctorSpecialisation = :specialisation")
//List<DoctorDto> findByDoctorSpecialisation(@Param("specialisation") String specialisation);








}
