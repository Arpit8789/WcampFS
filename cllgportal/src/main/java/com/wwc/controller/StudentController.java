package com.wwc.controller;

import com.wwc.model.Student;
import com.wwc.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Register Student
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        String result = studentService.registerStudent(student);
        switch (result) {
            case "CREATED":
                return new ResponseEntity<>("Student registered successfully!", HttpStatus.CREATED);
            case "BAD_REQUEST":
                return new ResponseEntity<>("Name and course must not be empty!", HttpStatus.BAD_REQUEST);
            case "CONFLICT":
                return new ResponseEntity<>("Student with this ID already exists!", HttpStatus.CONFLICT);
            default:
                return new ResponseEntity<>("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity <>("Student not found !", HttpStatus.NOT_FOUND);
    }
}
