package com.wojtekbier03.schoolsystem.student.repository;

import com.wojtekbier03.schoolsystem.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final List<Student> students;

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public List getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> getStudentsById(String id) {
        return students.stream()
                .filter(student -> student.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public void deleteStudent(String id){
        Student student = getStudentsById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
                students.remove(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Student student = getStudentsById(id).
                orElseThrow(() -> new IllegalArgumentException("Student not found"));
            student.setFirstName(updatedStudent.getFirstName());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setLastName(updatedStudent.getLastName());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            student.setPesel(updatedStudent.getPesel());
            student.setGender(updatedStudent.getGender());
        return student;
    }

    public List<Student> getStudentByLastName(String lastName) {
        return students.stream()
                .filter(student -> student.getLastName() != null && student.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
    public Student updateStudentBirthday(String id, Student studentNewData) {
        Student student = getStudentsById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        student.setDateOfBirth(studentNewData.getDateOfBirth());
        return student;
    }
}
