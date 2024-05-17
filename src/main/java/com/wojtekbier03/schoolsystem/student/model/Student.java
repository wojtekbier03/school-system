package com.wojtekbier03.schoolsystem.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  private String id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private LocalDate dateOfBirth;
  private String pesel;
  private Gender gender;
}
