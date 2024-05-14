package com.wojtekbier03.schoolsystem.student.service;

import com.wojtekbier03.schoolsystem.student.model.Student;
import com.wojtekbier03.schoolsystem.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(Student student) {
        studentRepository.addStudent(student);
        return student;
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.getStudentsById(id);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteStudent(id);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        studentRepository.updateStudent(id, updatedStudent);
        return updatedStudent;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.getStudentByLastName(lastName);
    }

}
