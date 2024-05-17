package com.wojtekbier03.schoolsystem.teacher.service;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import com.wojtekbier03.schoolsystem.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        checkId(teacher.getId());
        return teacherRepository.addTeacher(teacher);
    }

    public Teacher getTeacherById(String id) {
        return teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteTeacher(id);
    }

    public Teacher updateTeacher(String id, Teacher newTeacherData) {
        return teacherRepository.updateTeacher(id, newTeacherData);
    }

    public Teacher updateTeacherPhoneNumber(String id, Teacher newPhoneNumber) {
        return teacherRepository.updateTeacherPhoneNumber(id, newPhoneNumber);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    public List<Teacher> getTeachersByGender(Gender gender){
        return Optional.ofNullable(gender)
                .map(teacherRepository::getTeacherByGender)
                .orElseGet(teacherRepository::getAllTeachers);
    }
    public Teacher updateTeacherBirthDate(String id, Teacher teacherNewData) {
       return teacherRepository.updateTeacherBirthday(id, teacherNewData);
    }
    private void checkId(String id) {
        if (teacherRepository.getTeacherById(id).isPresent()){
            throw new IllegalArgumentException("ID already exists");
        }
    }
}
