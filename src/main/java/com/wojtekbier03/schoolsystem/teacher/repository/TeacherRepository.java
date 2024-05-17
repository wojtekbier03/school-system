package com.wojtekbier03.schoolsystem.teacher.repository;

import com.wojtekbier03.schoolsystem.student.model.Gender;
import com.wojtekbier03.schoolsystem.teacher.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeacherRepository {
    private final List<Teacher> teachers;


    public Teacher addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public void deleteTeacher(String id) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
        teachers.remove(teacher);
    }

    public Teacher updateTeacher(String id, Teacher teacherNewData) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
        teacher.setPhoneNumber(teacherNewData.getPhoneNumber());
        teacher.setFirstName(teacherNewData.getFirstName());
        teacher.setLastName(teacherNewData.getLastName());
        teacher.setDateOfBirth(teacherNewData.getDateOfBirth());
        teacher.setPesel(teacherNewData.getPesel());
        teacher.setGender(teacherNewData.getGender());
        teacher.setSalary(teacherNewData.getSalary());
        return teacher;
    }

    public Teacher updateTeacherPhoneNumber(String id, Teacher teacherNewData) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));

        teacher.setPhoneNumber(teacherNewData.getPhoneNumber());
        return teacher;
    }

    public List<Teacher> getTeacherByGender(Gender gender) {
        return teachers.stream()
                .filter(teacher -> teacher.getGender() != null && teacher.getGender().equals(gender))
                .toList();
    }

    public Teacher updateTeacherBirthday(String id, Teacher teacherNewData) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
        teacher.setDateOfBirth(teacherNewData.getDateOfBirth());
        return teacher;
    }
}
