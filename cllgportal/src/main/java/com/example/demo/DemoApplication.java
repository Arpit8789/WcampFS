package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//package wwc.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//        import wwc.model.Student;
//import wwc.services.StudentService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    // 1. Register Student
//    @PostMapping("/register")
//    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
//        Optional<Student> result = studentService.registerStudent(student);
//
//        if (result.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Validation failed: name and course must not be empty.");
//        }
//        if (result.get().getId() == -1) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body("Student with ID " + student.getId() + " already exists.");
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(result.get());
//    }
//
//    // 2. Get All Students
//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents() {
//        return ResponseEntity.ok(studentService.getAllStudents());
//    }
//
//    // 3. Get Student by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getStudentById(@PathVariable int id) {
//        Optional<Student> student = studentService.getStudentById(id);
//        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body("Student with ID " + id + " not found.");
//    }
//
//    // 4. Delete Student
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
//        boolean deleted = studentService.deleteStudent(id);
//        if (deleted) {
//            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body("Student with ID " + id + " not found.");
//    }
//}