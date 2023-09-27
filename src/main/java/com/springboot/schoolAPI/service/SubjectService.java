package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.dto.Subject;
import com.springboot.schoolAPI.entity.StudentEntity;
import com.springboot.schoolAPI.entity.SubjectEntity;
import com.springboot.schoolAPI.entity.TeacherEntity;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.mapper.SubjectMapper;
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

    public List<SubjectEntity> getAllSubject() {

        return subjectRepository.findAll();

    }

    public SubjectEntity getSubjectById(Long id) {

        return subjectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

    }

    public SubjectEntity createSubject(SubjectEntity subject) {

        return subjectRepository.save(subject);

    }

    public SubjectEntity updateSubject(Subject subject, Long id) {
        SubjectEntity existingSubject = getSubjectById(id);
//        existingSubject.setSubjectCode(subject.getSubjectCode());
//        existingSubject.setDetail(subject.getDetail());
//        return subjectRepository.save(existingSubject);
        SubjectEntity updatedEntity = SubjectMapper.INSTANCE.update(subject, existingSubject);
        return subjectRepository.save(updatedEntity);

    }

    public SubjectEntity addStudentToSubject(Long subjectId, Long studentId) {

        SubjectEntity subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        subject.enrollStudent(student);
        return subjectRepository.save(subject);

    }

    public SubjectEntity addTeacherToSubject(Long subjectId, Long teacherId) {

        SubjectEntity subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);

    }

    public void deleteSubject(Long id) {

        SubjectEntity existingSubject = getSubjectById(id);
        subjectRepository.delete(existingSubject);

    }
}
