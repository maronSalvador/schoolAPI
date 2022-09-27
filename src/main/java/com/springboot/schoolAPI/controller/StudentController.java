package com.springboot.schoolAPI.controller;

import com.springboot.schoolAPI.entity.Student;
import com.springboot.schoolAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudent());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.getStudentById(id));

    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        return  ResponseEntity.ok(studentService.createStudent(student));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {

        return ResponseEntity.ok(studentService.updateStudent(student, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
        return ResponseEntity.ok("Successfully deleted");

    }
}
