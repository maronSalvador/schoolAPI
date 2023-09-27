package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.dto.Student;
import com.springboot.schoolAPI.entity.StudentEntity;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.mapper.StudentMapper;
import com.springboot.schoolAPI.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {

        return studentRepository.findAll();

    }

    public StudentEntity getStudentById(Long id) {

        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

    }

    public StudentEntity createStudent(StudentEntity student) {

        return studentRepository.save(student);

    }

    public StudentEntity updateStudent(Student student, Long id) {
        StudentEntity existingStudent = getStudentById(id);
        StudentEntity updatedEntity = StudentMapper.INSTANCE.update(student,  existingStudent);
        return studentRepository.save(updatedEntity);
    }

    public void deleteStudent(Long id) {

        StudentEntity existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);

    }

}
