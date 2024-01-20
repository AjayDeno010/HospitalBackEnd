package com.medicalAppointment.service.jwt;

import com.medicalAppointment.entity.UserEntity;
import com.medicalAppointment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user= userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("UserName not found exception"));
 Set<GrantedAuthority> authorites=   user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        return new User(
                user.getUserName(),
                user.getPassword(),
                authorites
        );
    }
}
