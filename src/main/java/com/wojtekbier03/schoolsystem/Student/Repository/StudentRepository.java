package com.wojtekbier03.schoolsystem.Student.Repository;

import com.wojtekbier03.schoolsystem.Student.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
        public List getAllStudents(){
            return new ArrayList<>(students);
        }

    public Student getStudentsById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void deleteStudentById(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }
    public void updateStudentById(String id, Student updatedStudent) {
        Student student = getStudentsById(id);
        student.setFirstName(updatedStudent.getFirstName());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        student.setLastName(updatedStudent.getLastName());
        student.setDateOfBirth(updatedStudent.getDateOfBirth());
        student.setPesel(updatedStudent.getPesel());
        student.setGender(updatedStudent.getGender());
    }
    public List<Student> getStudentByLastName(String lastName){
        return students.stream()
                .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }
}
