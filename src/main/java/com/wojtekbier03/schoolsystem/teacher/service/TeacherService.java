package com.wojtekbier03.schoolsystem.teacher.service;

import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import com.wojtekbier03.schoolsystem.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teacherRepository.getTeacherById(id);
    }

    public void deleteTeacherById(String id) {
        teacherRepository.deleteTeacherById(id);
    }

    public void updateTeacher(Teacher currentTeacher, Teacher updatedTeacher) {
        teacherRepository.updateTeacher(currentTeacher, updatedTeacher);
    }

    public Teacher updateTeacherPhoneNumber(String id, String phoneNumber) {
        teacherRepository.updateTeacherPhoneNumber(id, phoneNumber);
        return null;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public List<Teacher> getTeachersByGender(String gender) {
        return teacherRepository.getTeachersByGender(gender);
    }
}
