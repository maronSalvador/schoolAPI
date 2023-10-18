package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.exceptions.IllegalArgumentException;
import com.springboot.schoolAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;


public class EntityNumberGenerator {

    public static int numberOfStudent;
    public static int numberOfTeacher;

    public static String entityNumberGenerator(String code) {
        String prefix = LocalDate.now().toString().replace("-", "");
        int counter = 0;
        switch (code) {
            case "001":
                numberOfStudent++;
                counter = numberOfStudent;
                break;
            case "002":
                numberOfTeacher++;
                counter = numberOfTeacher;
                break;
            default:
                throw IllegalArgumentException.withMessageAndPath("Unsupported code.");
        }
        return prefix + "-" + code + "-" + String.format("%04d", counter);
    }
}
