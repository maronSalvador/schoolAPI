package com.springboot.schoolAPI.controller;

import com.springboot.schoolAPI.entity.Subject;
import com.springboot.schoolAPI.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubject() {

        return ResponseEntity.ok(subjectService.getAllSubject());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {

        return ResponseEntity.ok(subjectService.getSubjectById(id));

    }

    @PostMapping
    public ResponseEntity<Subject> createStudent(@RequestBody Subject subject) {

        return  ResponseEntity.ok(subjectService.createSSubject(subject));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateStudent(@RequestBody Subject subject, @PathVariable Long id) {

        return ResponseEntity.ok(subjectService.updateSubject(subject, id));

    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public ResponseEntity<Subject> addStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {

        return ResponseEntity.ok(subjectService.addStudentToSubject(subjectId, studentId));

    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    public ResponseEntity<Subject> addTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {

        return ResponseEntity.ok(subjectService.addTeacherToSubject(subjectId, teacherId));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {

        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Successfully deleted");

    }
}
