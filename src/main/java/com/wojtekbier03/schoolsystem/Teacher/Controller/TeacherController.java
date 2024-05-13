package com.wojtekbier03.schoolsystem.Teacher.Controller;

import com.wojtekbier03.schoolsystem.Teacher.Model.Teacher;
import com.wojtekbier03.schoolsystem.Teacher.Service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Teacher getTeacherById(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable String id) {
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable String id, @RequestBody Teacher updatedTeacher) {
        teacherService.updateTeacher(id, updatedTeacher);
    }

    @PatchMapping("/{id}/phoneNumber")
    public void updateTeacherPhoneNumber(@PathVariable String id, @RequestParam String phoneNumber) {
        teacherService.updateTeacherPhoneNumber(id, phoneNumber);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{gender}")
    public List<Teacher> getTeachersByGender(@PathVariable String gender) {
        return teacherService.getTeachersByGender(gender);
    }
}
