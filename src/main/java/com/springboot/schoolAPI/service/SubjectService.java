package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.entity.Student;
import com.springboot.schoolAPI.entity.Subject;
import com.springboot.schoolAPI.entity.Teacher;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.repository.StudentRepository;
import com.springboot.schoolAPI.repository.SubjectRepository;
import com.springboot.schoolAPI.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    public List<Subject> getAllSubject() {

        return subjectRepository.findAll();

    }

    public Subject getSubjectById(Long id) {

        return subjectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

    }

    public Subject createSSubject(Subject subject) {

        return subjectRepository.save(subject);

    }

    public Subject updateSubject(Subject subject, Long id) {
        Subject existingSubject = getSubjectById(id);
        existingSubject.setSubjectName(subject.getSubjectName());
        return subjectRepository.save(existingSubject);

    }

    public Subject addStudentToSubject(Long subjectId, Long studentId) {

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        subject.enrollStudent(student);
        return subjectRepository.save(subject);

    }

    public Subject addTeacherToSubject(Long subjectId, Long teacherId) {

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);

    }

    public void deleteSubject(Long id) {

        Subject existingSubject = getSubjectById(id);
        subjectRepository.delete(existingSubject);

    }
}
