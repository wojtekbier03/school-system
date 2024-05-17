package com.wojtekbier03.schoolsystem.teacher.model;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String pesel;
    private Gender gender;
    private BigDecimal salary;
}
