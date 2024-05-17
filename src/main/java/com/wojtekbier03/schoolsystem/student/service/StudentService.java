package com.wojtekbier03.schoolsystem.student.service;

import com.wojtekbier03.schoolsystem.student.model.Student;
import com.wojtekbier03.schoolsystem.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(Student student) {
        checkId(student.getId());
       return studentRepository.addStudent(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.getStudentsById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public void deleteStudent(String id) {
        studentRepository.deleteStudent(id);
    }

    public Student updateStudent(String id, Student studentNewData) {
        return studentRepository.updateStudent(id, studentNewData);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.getStudentByLastName(lastName);
    }
    public Student updateStudentBirthday(String id, Student studentNewData) {
       return studentRepository.updateStudentBirthday(id, studentNewData);
    }
    public void checkId(String id) {
        if (studentRepository.getStudentsById(id).isPresent()) {
            throw new IllegalArgumentException("Student with id " + id + " already exists");
        }
        }
    }
