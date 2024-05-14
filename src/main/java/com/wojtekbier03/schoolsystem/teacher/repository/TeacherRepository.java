package com.wojtekbier03.schoolsystem.teacher.repository;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public Teacher addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    public void deleteTeacherById(String id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void updateTeacher(Teacher currentTeacher, Teacher newData) {
        currentTeacher.setPhoneNumber(newData.getPhoneNumber());
        currentTeacher.setFirstName(newData.getFirstName());
        currentTeacher.setLastName(newData.getLastName());
        currentTeacher.setDateOfBirth(newData.getDateOfBirth());
        currentTeacher.setPesel(newData.getPesel());
        currentTeacher.setGender(newData.getGender());
        currentTeacher.setSalary(newData.getSalary());
    }

    public void updateTeacherPhoneNumber(String id, String phoneNumber) {
        Optional<Teacher> teacher = getTeacherById(id);
        if (teacher.isPresent()) {
            teacher.get().setPhoneNumber(phoneNumber);
        }
    }

    public List<Teacher> getTeachersByGender(String gender) {
        Gender genderEnum = Gender.valueOf(gender.toUpperCase());
        return teachers.stream()
                .filter(teacher -> genderEnum.equals(teacher.getGender()))
                .toList();
    }
}
