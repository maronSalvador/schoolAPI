package com.springboot.schoolAPI.controller;

import com.springboot.schoolAPI.dto.Subject;
import com.springboot.schoolAPI.entity.SubjectEntity;
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
    public ResponseEntity<List<SubjectEntity>> getAllSubject() {

        return ResponseEntity.ok(subjectService.getAllSubject());

    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable Long id) {

        return ResponseEntity.ok(subjectService.getSubjectById(id));

    }

    @PostMapping
    public ResponseEntity<SubjectEntity> createStudent(@RequestBody SubjectEntity subject) {

        return  ResponseEntity.ok(subjectService.createSubject(subject));

    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectEntity> updateStudent(@RequestBody Subject subject, @PathVariable Long id) {

        return ResponseEntity.ok(subjectService.updateSubject(subject, id));

    }

    @PostMapping("/{subjectId}/students/{studentId}")
    public ResponseEntity<SubjectEntity> addStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {

        return ResponseEntity.ok(subjectService.addStudentToSubject(subjectId, studentId));

    }

    @PostMapping("/{subjectId}/teachers/{teacherId}")
    public ResponseEntity<SubjectEntity> addTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {

        return ResponseEntity.ok(subjectService.addTeacherToSubject(subjectId, teacherId));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {

        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Successfully deleted");

    }
}
