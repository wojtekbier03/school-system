package com.wojtekbier03.schoolsystem.Student.Service;

import com.wojtekbier03.schoolsystem.Student.Model.Student;
import com.wojtekbier03.schoolsystem.Student.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.getStudentsById(id);
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteStudentById(id);
    }

    public void updateStudent(String id, Student updatedStudent) {
        studentRepository.updateStudentById(id, updatedStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.getStudentByLastName(lastName);
    }

}
