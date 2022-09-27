package com.springboot.schoolAPI.service;


import com.springboot.schoolAPI.entity.Teacher;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {

        return teacherRepository.findAll();

    }

    public Teacher getTeacherById(Long id) {

        return teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

    }

    public Teacher createTeacher(Teacher teacher) {

        return teacherRepository.save(teacher);

    }

    public Teacher updateTeacher(Teacher teacher, Long id) {
        Teacher existingTeacher = getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        return teacherRepository.save(existingTeacher);

    }

    public void deleteTeacher(Long id) {

        Teacher existingTeacher = getTeacherById(id);
        teacherRepository.delete(existingTeacher);

    }

}


