package com.medicalAppointment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
@Configuration
public class CustomObjectMapper {

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Configure date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(dateFormat);

        // Configure time format
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ToStringSerializer(java.sql.Time.class));
        objectMapper.registerModule(module);

        // Disable serialization of timestamps as numbers
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper;
    }
}

