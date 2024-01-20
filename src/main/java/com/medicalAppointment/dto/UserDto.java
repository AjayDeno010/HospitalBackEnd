package com.medicalAppointment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private String age;
    private String address;
    private String emergencyContact;
    private List<String> medicalHistory;
    private String password;
    private String userName;
}
