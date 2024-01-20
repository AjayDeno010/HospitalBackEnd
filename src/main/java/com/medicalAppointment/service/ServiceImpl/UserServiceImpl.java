package com.medicalAppointment.service.ServiceImpl;

import com.medicalAppointment.Exception.UserNameAndPasswordNotAvailable;
import com.medicalAppointment.dto.UserDto;
import com.medicalAppointment.entity.UserEntity;
import com.medicalAppointment.repository.RoleRepository;
import com.medicalAppointment.repository.UserRepository;
import com.medicalAppointment.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    @Transactional
    public UserDto createUser(UserDto userDto) {
      UserEntity save=  modelMapper.map(userDto, UserEntity.class);
      save.setName("admin");
      save.setPassword(passwordEncoder.encode(userDto.getPassword()));
      UserEntity savedUser=  userRepository.save(save);
        roleRepository.insertUserRole(savedUser.getUserId(), 1);
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto editUser(UserDto userDto, String id) {
      UserEntity user=  userRepository.findById(id).get();
        if (userDto !=null){
            if (userDto.getAddress() !=null){
                user.setAddress(userDto.getAddress());
            }
            if (userDto.getAge() !=null){
                user.setAge(userDto.getAge());
            }
            if (userDto.getName() != null){
                user.setName(user.getName());
            }
            if (userDto.getMedicalHistory() !=null){
                user.setMedicalHistory(userDto.getMedicalHistory());
            }
            if (userDto.getEmergencyContact() !=null){
                user.setEmergencyContact(userDto.getEmergencyContact());
            }

        }
        UserEntity updatedUser= userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto getUser(String id) {
     UserEntity user=   userRepository.findById(id).get();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity login(String userName, String password) {
    UserEntity user= userRepository.findByUserName(userName).orElseThrow(()->new UsernameNotFoundException("UserName not found"));
    if(user.getUserName().equals(userName)&& passwordEncoder.matches(password,user.getPassword())){
        return user;
    }
        throw new  UserNameAndPasswordNotAvailable("UserName and password is wrong");
    }

//    @Transactional
//    public UserDto createUserWithRole(UserDto userDto) {
//        UserDto savedUser = createUser(userDto);
//        roleRepository.insertUserRole(savedUser.getUserId(), 1);
//        return savedUser;
//    }

}
