package com.medicalAppointment.Exception;

public class NoDoctorsAvailableException extends RuntimeException {
    public NoDoctorsAvailableException(String message) {
        super(message);
    }
}
