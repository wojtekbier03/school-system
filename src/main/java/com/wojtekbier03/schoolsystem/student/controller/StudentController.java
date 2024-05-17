package com.wojtekbier03.schoolsystem.student.controller;

import com.wojtekbier03.schoolsystem.student.model.Student;
import com.wojtekbier03.schoolsystem.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
        return updatedStudent;
    }

    @GetMapping
    public List<Student> getStudentsByLastName(@RequestParam String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @PatchMapping("{id}/dateOfBirth")
    public Student updateTeacherBirthDate(@PathVariable String id, @RequestBody Student studentNewData) {
        return studentService.updateStudentBirthday(id, studentNewData);
    }
}
