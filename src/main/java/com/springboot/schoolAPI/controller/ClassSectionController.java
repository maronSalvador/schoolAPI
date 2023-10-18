package com.springboot.schoolAPI.controller;

import com.springboot.schoolAPI.entity.ClassSectionEntity;
import com.springboot.schoolAPI.service.ClassSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-section")
@RequiredArgsConstructor
public class ClassSectionController {

    private final ClassSectionService classSectionService;

    @GetMapping
    public List<ClassSectionEntity> getAllSection() {
        return classSectionService.getAllSection();
    }
    @PostMapping("/create")
    public ClassSectionEntity createSection(@RequestBody ClassSectionEntity section) {
        return classSectionService.createSection(section);
    }

    @PostMapping("/section/{sectionId}/student/{studentId}")
    public ClassSectionEntity enrollStudent(@PathVariable Long sectionId, @PathVariable Long studentId) {
        return classSectionService.enrollStudentToSection(sectionId, studentId);
    }
}
