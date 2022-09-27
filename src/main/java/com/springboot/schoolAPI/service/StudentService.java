package com.springboot.schoolAPI.service;

import com.springboot.schoolAPI.entity.Student;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent() {

        return studentRepository.findAll();

    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);

    }

    public Student updateStudent(Student student, Long id) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return studentRepository.save(existingStudent);

    }

    public void deleteStudent(Long id) {

        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);

    }

}
