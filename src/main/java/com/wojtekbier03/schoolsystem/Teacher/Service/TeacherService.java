package com.wojtekbier03.schoolsystem.Teacher.Service;

import com.wojtekbier03.schoolsystem.Teacher.Model.Teacher;
import com.wojtekbier03.schoolsystem.Teacher.Repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }

    public Teacher getTeacherById(String id) {
        return teacherRepository.getTeacherById(id);
    }

    public void deleteTeacherById(String id) {
        teacherRepository.deleteTeacherById(id);
    }

    public void updateTeacher(String id, Teacher updatedTeacher) {
        teacherRepository.updateTeacherById(id, updatedTeacher);
    }

    public void updateTeacherPhoneNumber(String id, String phoneNumber) {
        teacherRepository.updateTeacherPhoneNumber(id, phoneNumber);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public List<Teacher> getTeachersByGender(String gender) {
        return teacherRepository.getTeachersByGender(gender);
    }
}
