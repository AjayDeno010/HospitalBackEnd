package com.medicalAppointment.Exception;

public class UserNameAndPasswordNotAvailable extends RuntimeException{
    public UserNameAndPasswordNotAvailable(String message) {
        super(message);
    }
}
