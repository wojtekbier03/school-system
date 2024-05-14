package com.wojtekbier03.schoolsystem.teacher.controller;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import com.wojtekbier03.schoolsystem.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable String id) {
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Teacher currentTeacher, @RequestBody Teacher updatedTeacher) {
        teacherService.updateTeacher(currentTeacher, updatedTeacher);
    }

    @PatchMapping("/{id}/phoneNumber")
    public Teacher updateTeacherPhoneNumber(@PathVariable String id, @RequestParam String phoneNumber) {
       return teacherService.updateTeacherPhoneNumber(id, phoneNumber);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{gender}")
    public List<Teacher> getTeachersByGender(@PathVariable Gender gender) {
        return teacherService.getTeachersByGender(String.valueOf(gender));
    }
}
