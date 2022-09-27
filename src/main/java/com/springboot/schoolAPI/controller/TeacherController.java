package com.springboot.schoolAPI.controller;

import com.springboot.schoolAPI.entity.Teacher;
import com.springboot.schoolAPI.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher() {

        return ResponseEntity.ok(teacherService.getAllTeacher());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {

        return ResponseEntity.ok(teacherService.getTeacherById(id));

    }

    @PostMapping
    public ResponseEntity<Teacher> createStudent(@RequestBody Teacher teacher) {

        return  ResponseEntity.ok(teacherService.createTeacher(teacher));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id) {

        return ResponseEntity.ok(teacherService.updateTeacher(teacher, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {

        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Successfully deleted");

    }
}
