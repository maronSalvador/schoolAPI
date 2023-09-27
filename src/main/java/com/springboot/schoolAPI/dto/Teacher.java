package com.springboot.schoolAPI.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Teacher {

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    private int age;

    private String address;

    private String email;

}
