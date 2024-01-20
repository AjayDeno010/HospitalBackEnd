package com.medicalAppointment.service;

import com.medicalAppointment.dto.UserDto;
import com.medicalAppointment.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface UserService {
   UserDto createUser(UserDto userDto);
    UserDto editUser(UserDto userDto, String id);
    UserDto getUser(String id);
    void deleteUser(String id);
    UserEntity login(String userName, String password);
//    UserDto createUserWithRole(UserDto userDto);
}
