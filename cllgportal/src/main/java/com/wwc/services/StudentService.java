package com.wwc.services;

import com.wwc.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final Map<Integer, Student> studentDB = new HashMap<>();

    // Register student
    public String registerStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()
                || student.getCourse() == null || student.getCourse().trim().isEmpty()) {
            return "BAD_REQUEST";
        }
        if (studentDB.containsKey(student.getId())) {
            return "CONFLICT";
        }
        studentDB.put(student.getId(), student);
        return "CREATED";
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    // Get student by ID
    public Student getStudentById(int id) {
        return studentDB.get(id);
    }

    // Delete student
    public boolean deleteStudent(int id) {
        if (studentDB.containsKey(id)) {
            studentDB.remove(id);
            return true;
        }
        return false;
    }
}