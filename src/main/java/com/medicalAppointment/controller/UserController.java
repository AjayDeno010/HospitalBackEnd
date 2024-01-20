package com.medicalAppointment.controller;

import com.medicalAppointment.dto.UserDto;
import com.medicalAppointment.dto.UserloginDto;
import com.medicalAppointment.entity.UserEntity;
import com.medicalAppointment.repository.RoleRepository;
import com.medicalAppointment.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @PostMapping("create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       UserDto savedUser= userService.createUser(userDto);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PostMapping("login")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<UserEntity> login(@RequestBody UserloginDto userloginDto){
      UserEntity user= userService.login(userloginDto.getUsername(),userloginDto.getPassword());
      return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("{id}/getUser")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<UserDto> getUser(@PathVariable String id){
      UserDto userDto=  userService.getUser(id);
      return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @PutMapping("{id}/update")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto,@PathVariable String id){
      UserDto userDto1=  userService.editUser(userDto,id);
      return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }
    @DeleteMapping("{id}/delete")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
    }

}
