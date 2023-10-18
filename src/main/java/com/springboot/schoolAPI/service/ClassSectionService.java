package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.entity.ClassSectionEntity;
import com.springboot.schoolAPI.entity.StudentEntity;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.repository.ClassSectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassSectionService {

    private final ClassSectionRepository classSectionRepository;
    private final StudentService studentService;

    public List<ClassSectionEntity> getAllSection() {
        return classSectionRepository.findAll();
    }

    public ClassSectionEntity findSectionById(Long id) {
        return classSectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class section not found."));
    }

    public ClassSectionEntity findSectionByName(String name) {
        Optional<ClassSectionEntity> section = classSectionRepository.findByName(name);
        if (section.isPresent()) {
            return section.get();
        }
        throw new ResourceNotFoundException("Section name: " + name + " not found.");
    }

    public ClassSectionEntity createSection(ClassSectionEntity section) {
        return classSectionRepository.save(section);
    }

    public ClassSectionEntity enrollStudentToSection(Long sectionId, Long studentId) {
        ClassSectionEntity section = findSectionById(sectionId);
        StudentEntity student = studentService.getStudentById(sectionId);
        section.setNumberOfStudentsEnrolled(section.getNumberOfStudentsEnrolled() + 1);
        section.addStudentToSection(student);
        return classSectionRepository.save(section);
    }
}
