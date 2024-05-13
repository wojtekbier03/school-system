package com.wojtekbier03.schoolsystem.Teacher.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String dateOfBirth;
    private String pesel;
    private String gender;
    private double salary;
}
