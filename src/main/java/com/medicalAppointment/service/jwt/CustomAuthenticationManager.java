package com.medicalAppointment.service.jwt;

import com.medicalAppointment.entity.UserEntity;
import com.medicalAppointment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomAuthenticationManager implements AuthenticationManager {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String username=  authentication.getName();
    String password=  authentication.getCredentials().toString();
    if (validateUserNameAndPassword(username,password)){
        try {
            return new UsernamePasswordAuthenticationToken(username, password);
        } catch (AuthenticationException e) {
            e.printStackTrace();  // Log or print the exception details
            throw e;
        }
    } else {
        throw new  AuthenticationException("invalid credential"){
        };
    }

    }
    public boolean validateUserNameAndPassword(String userName,String password){

        try {
            UserEntity user = userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("UserName not found exception"));
            boolean equalUsername=user.getUserName().equals(userName);
            boolean equalPassword= passwordEncoder.matches(password,user.getPassword());
            return equalPassword&equalUsername;
        } catch (Exception e) {
            e.printStackTrace(); // Log or print the exception details
            throw e; // Re-throw the exception if needed
        }

    }
}
