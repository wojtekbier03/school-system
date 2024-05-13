package com.wojtekbier03.schoolsystem.Teacher.Repository;

import com.wojtekbier03.schoolsystem.Teacher.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Teacher getTeacherById(String id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteTeacherById(String id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void updateTeacherById(String id, Teacher updatedTeacher) {
        Teacher teacher = getTeacherById(id);
        if (teacher != null) {
            teacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
            teacher.setFirstName(updatedTeacher.getFirstName());
            teacher.setLastName(updatedTeacher.getLastName());
            teacher.setDateOfBirth(updatedTeacher.getDateOfBirth());
            teacher.setPesel(updatedTeacher.getPesel());
            teacher.setGender(updatedTeacher.getGender());
            teacher.setSalary(updatedTeacher.getSalary());
        }
    }

    public void updateTeacherPhoneNumber(String id, String phoneNumber) {
        Teacher teacher = getTeacherById(id);
        if (teacher != null) {
            teacher.setPhoneNumber(phoneNumber);
        }
    }


    public List<Teacher> getTeachersByGender(String gender) {
        return teachers.stream()
                .filter(teacher -> teacher.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }
}
