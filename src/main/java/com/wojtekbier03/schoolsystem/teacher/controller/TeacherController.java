package com.wojtekbier03.schoolsystem.teacher.controller;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import com.wojtekbier03.schoolsystem.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable ("id") String id) {
      return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable("id") String id, @RequestBody Teacher newTeacherData){
        return teacherService.updateTeacher(id, newTeacherData);
    }

    @PatchMapping("{id}/phoneNumber")
    public Teacher updateTeacherPhoneNumber(@PathVariable String id, @RequestBody Teacher teacher) {
       return teacherService.updateTeacherPhoneNumber(id, teacher);
    }

    @GetMapping
    public List<Teacher> getTeachersByGender(@RequestParam(required = false) Gender gender){

        return teacherService.getTeachersByGender(gender);
    }

    @PatchMapping("{id}/dateOfBirth")
    public Teacher updateTeacherBirthDate(@PathVariable String id, @RequestBody Teacher teacherNewData) {
        return teacherService.updateTeacherBirthDate(id, teacherNewData);
    }
}
