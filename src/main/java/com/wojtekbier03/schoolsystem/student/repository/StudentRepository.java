package com.wojtekbier03.schoolsystem.student.repository;

import com.wojtekbier03.schoolsystem.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> getStudentsById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Student student = getStudentsById(id).orElse(null);
        if (student != null) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setLastName(updatedStudent.getLastName());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            student.setPesel(updatedStudent.getPesel());
            student.setGender(updatedStudent.getGender());
        }
        return student;
    }


    public List<Student> getStudentByLastName(String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
}
