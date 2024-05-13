package com.wojtekbier03.schoolsystem.Student.Controller;

import com.wojtekbier03.schoolsystem.Student.Model.Student;
import com.wojtekbier03.schoolsystem.Student.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/lastName/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }
}
