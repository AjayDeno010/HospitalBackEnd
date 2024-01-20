package com.medicalAppointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserloginDto {
    private String username;
    private String password;
}
